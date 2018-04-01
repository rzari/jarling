package org.jarling.models.budgeting;

import com.google.gson.annotations.JsonAdapter;
import org.jarling.models.common.CurrencyAndAmount;
import org.jarling.models.gson.SavingsGoalDeserialzer;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
@JsonAdapter(SavingsGoalDeserialzer.class)
public class SavingsGoal {

    private String uid;
    private String name;
    private CurrencyAndAmount target;
    private CurrencyAndAmount totalSaved;
    private Integer savedPercentage;

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public CurrencyAndAmount getTarget() {
        return target;
    }

    public CurrencyAndAmount getTotalSaved() {
        return totalSaved;
    }

    public Integer getSavedPercentage() {
        return savedPercentage;
    }

    @Override
    public String toString() {
        return "SavingsGoal{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", target=" + target +
                ", totalSaved=" + totalSaved +
                ", savedPercentage=" + savedPercentage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SavingsGoal that = (SavingsGoal) o;

        if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (target != null ? !target.equals(that.target) : that.target != null) return false;
        if (totalSaved != null ? !totalSaved.equals(that.totalSaved) : that.totalSaved != null) return false;
        return savedPercentage != null ? savedPercentage.equals(that.savedPercentage) : that.savedPercentage == null;
    }

    @Override
    public int hashCode() {
        int result = uid != null ? uid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (target != null ? target.hashCode() : 0);
        result = 31 * result + (totalSaved != null ? totalSaved.hashCode() : 0);
        result = 31 * result + (savedPercentage != null ? savedPercentage.hashCode() : 0);
        return result;
    }
}
