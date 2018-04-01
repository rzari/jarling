package org.jarling.models.common;


/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class RecurringTransfer {

    private RecurrenceRule recurrenceRule;
    private CurrencyAndAmount currencyAndAmount;

    public RecurringTransfer(){}

    public RecurringTransfer(RecurrenceRule recurrenceRule, CurrencyAndAmount currencyAndAmount){
        assert recurrenceRule != null;
        assert currencyAndAmount != null;
        this.recurrenceRule = recurrenceRule;
        this.currencyAndAmount = currencyAndAmount;
    }

    public RecurrenceRule getRecurrenceRule() {
        return recurrenceRule;
    }

    public CurrencyAndAmount getCurrencyAndAmount() {
        return currencyAndAmount;
    }

    @Override
    public String toString() {
        return "RecurringTransfer{" +
                "recurrenceRule=" + recurrenceRule +
                ", currencyAndAmount=" + currencyAndAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecurringTransfer that = (RecurringTransfer) o;

        if (recurrenceRule != null ? !recurrenceRule.equals(that.recurrenceRule) : that.recurrenceRule != null)
            return false;
        return currencyAndAmount != null ? currencyAndAmount.equals(that.currencyAndAmount) : that.currencyAndAmount == null;
    }

    @Override
    public int hashCode() {
        int result = recurrenceRule != null ? recurrenceRule.hashCode() : 0;
        result = 31 * result + (currencyAndAmount != null ? currencyAndAmount.hashCode() : 0);
        return result;
    }
}
