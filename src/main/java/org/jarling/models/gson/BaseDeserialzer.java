package org.jarling.models.gson;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import java.lang.reflect.Field;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public abstract class BaseDeserialzer implements JsonDeserializer {

    protected final Gson gson = new Gson();

    //Access the Addresses objects private fields and assign new Address instances to them
    protected void assignObjectField(Object jsonResponseInstance, JsonElement jsonElement, String member, Class clazz){

        Field memberField;
        try {
            memberField = jsonResponseInstance.getClass().getDeclaredField(member);
            memberField.setAccessible(true);
            if (jsonElement == null){
                memberField.set(jsonResponseInstance, clazz.newInstance());
            }else {
                memberField.set(jsonResponseInstance, gson.fromJson(jsonElement, clazz));
            }
        } catch (NoSuchFieldException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //Access the Addresses objects private fields and assign new Address instances to them
    protected void assignField(Object jsonResponseInstance, JsonElement jsonElement, String member, Class clazz, Object defaultValue){

        Field memberField;
        try {
            memberField = jsonResponseInstance.getClass().getDeclaredField(member);
            memberField.setAccessible(true);
            if (jsonElement == null){
                memberField.set(jsonResponseInstance, defaultValue);
            }else {
                memberField.set(jsonResponseInstance, gson.fromJson(jsonElement, clazz));
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
