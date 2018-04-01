package org.jarling.models.gson;

import com.google.gson.*;
import org.jarling.models.common.CurrencyAndAmount;
import org.jarling.models.budgeting.SavingsGoal;

import java.lang.reflect.Type;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class SavingsGoalDeserialzer extends BaseDeserialzer{

    private final Class<?> clazz = SavingsGoal.class;

    public SavingsGoal deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        // Target may be blank
        final JsonObject jsonObject = jsonElement.getAsJsonObject();

        Object savingsGoalInstance = null;
        try {
            savingsGoalInstance = clazz.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        assignField(savingsGoalInstance, jsonObject.get("uid"), "uid", String.class,
                //Not sure if this is Starling API design, but if the UID is null, attempt to get it from the photo link.
                jsonObject.getAsJsonObject("_links")
                        .getAsJsonObject("photo")
                        .get("href")
                        .getAsString()
                        .replace("api/v1/savings-goals/", "")
                        .replace("/photo", ""));
        assignField(savingsGoalInstance, jsonObject.get("name"), "name", String.class, "");
        assignField(savingsGoalInstance, jsonObject.get("savedPercentage"), "savedPercentage", Integer.class, 0);
        assignObjectField(savingsGoalInstance, jsonObject.get("totalSaved"), "totalSaved", CurrencyAndAmount.class);
        assignObjectField(savingsGoalInstance, jsonObject.get("target"), "target", CurrencyAndAmount.class);

        return (SavingsGoal) savingsGoalInstance;
    }
}
