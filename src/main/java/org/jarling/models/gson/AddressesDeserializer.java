package org.jarling.models.gson;

import com.google.gson.*;
import org.jarling.models.Address;
import org.jarling.models.Addresses;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class AddressesDeserializer implements JsonDeserializer<Addresses> {

    private final Gson gson = new Gson();
    private final Class<?> clazz = Addresses.class;

    public Addresses deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        // Previous address is actually an array of previous addresses that may be blank.
        final JsonObject jsonObject = jsonElement.getAsJsonObject();
        final int numberOfPreviousAddresses = jsonObject.get("previous").getAsJsonArray().size();
        final JsonElement jsonCurrent = jsonObject.get("current");
        final JsonElement jsonPrevious = numberOfPreviousAddresses > 0 ? jsonObject.get("previous").getAsJsonArray().get(0) : null;

        Object addressesInstance = null;
        try {
            addressesInstance = clazz.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        assignAddress(addressesInstance, jsonCurrent, "current");
        assignAddress(addressesInstance, jsonPrevious, "previous");

        return (Addresses) addressesInstance;
    }

    //Access the Addresses objects private fields and assign new Address instances to them
    private void assignAddress(Object addressesInstance, JsonElement jsonAddress, String member){

        Field addressesField;
        try {
            addressesField = addressesInstance.getClass().getDeclaredField(member);
            addressesField.setAccessible(true);
            if (jsonAddress == null){
                addressesField.set(addressesInstance, Address.class.newInstance());
            }else {
                addressesField.set(addressesInstance, gson.fromJson(jsonAddress, Address.class));
            }
        } catch (NoSuchFieldException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
