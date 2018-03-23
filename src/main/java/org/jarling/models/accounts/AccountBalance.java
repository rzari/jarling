package org.jarling.models.accounts;

import java.math.BigDecimal;

/**
 *
 * Model class representing an accounts balance returned by the Account API.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class AccountBalance{

    private BigDecimal  acceptedOverdraft;
    private BigDecimal  amount;
    private BigDecimal  availableToSpend;
    private BigDecimal  clearedBalance;
    private String      currency;
    private BigDecimal  effectiveBalance;
    private BigDecimal  pendingTransactions;

    public BigDecimal getAcceptedOverdraft() {
        return acceptedOverdraft;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getAvailableToSpend() {
        return availableToSpend;
    }

    public BigDecimal getClearedBalance() {
        return clearedBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getEffectiveBalance() {
        return effectiveBalance;
    }

    public BigDecimal getPendingTransactions() {
        return pendingTransactions;
    }

    @Override
    public String toString() {
        return "AccountBalance{" +
                "acceptedOverdraft=" + acceptedOverdraft +
                ", amount=" + amount +
                ", availableToSpend=" + availableToSpend +
                ", clearedBalance=" + clearedBalance +
                ", currency='" + currency + '\'' +
                ", effectiveBalance=" + effectiveBalance +
                ", pendingTransactions=" + pendingTransactions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountBalance that = (AccountBalance) o;

        if (acceptedOverdraft != null ? !acceptedOverdraft.equals(that.acceptedOverdraft) : that.acceptedOverdraft != null)
            return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (availableToSpend != null ? !availableToSpend.equals(that.availableToSpend) : that.availableToSpend != null)
            return false;
        if (clearedBalance != null ? !clearedBalance.equals(that.clearedBalance) : that.clearedBalance != null)
            return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (effectiveBalance != null ? !effectiveBalance.equals(that.effectiveBalance) : that.effectiveBalance != null)
            return false;
        return pendingTransactions != null ? pendingTransactions.equals(that.pendingTransactions) : that.pendingTransactions == null;

    }

    @Override
    public int hashCode() {
        int result = acceptedOverdraft != null ? acceptedOverdraft.hashCode() : 0;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (availableToSpend != null ? availableToSpend.hashCode() : 0);
        result = 31 * result + (clearedBalance != null ? clearedBalance.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (effectiveBalance != null ? effectiveBalance.hashCode() : 0);
        result = 31 * result + (pendingTransactions != null ? pendingTransactions.hashCode() : 0);
        return result;
    }
}
