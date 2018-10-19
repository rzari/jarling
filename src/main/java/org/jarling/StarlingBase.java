package org.jarling;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Base service to provide some convenience functions and utilities to all service classes
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
abstract class StarlingBase {

    final Gson gson = new Gson();
    static final DateFormat transactionDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private JsonObject toJsonObject(String json){
        return gson.fromJson(json, JsonObject.class);
    }

    private String getJsonArray(String json, String memberName){
        JsonObject jsonObject = toJsonObject(json);
        String result;
        if (jsonObject.has("_embedded")){
            result = jsonObject.get("_embedded").getAsJsonObject().get(memberName).toString();
        } else{
            result = jsonObject.get(memberName).toString();
        }
        return result;
    }

    // https://stackoverflow.com/questions/14139437/java-type-generic-as-argument-for-gson
    final <T> List<T> fromJsonList(final Class<T[]> clazz, String json, String memberName){
        return Arrays.asList(gson.fromJson(getJsonArray(json, memberName), clazz));
    }

    final <T> T fromJson(String json, final Class<T> clazz){
        return gson.fromJson(json, clazz);
    }
}
