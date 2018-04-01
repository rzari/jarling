package org.jarling.models.gson;

import com.google.gson.*;
import org.jarling.models.common.Address;
import org.jarling.models.common.Addresses;

import java.lang.reflect.Type;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class AddressesDeserializer extends BaseDeserialzer {

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

        assignObjectField(addressesInstance, jsonCurrent, "current", Address.class);
        assignObjectField(addressesInstance, jsonPrevious, "previous", Address.class);

        return (Addresses) addressesInstance;
    }
}
