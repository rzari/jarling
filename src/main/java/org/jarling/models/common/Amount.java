package org.jarling.models.common;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class Amount {

    private CurrencyAndAmount amount;

    public Amount(CurrencyAndAmount amount){
        this.amount = amount;
    }

    public CurrencyAndAmount getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount amount1 = (Amount) o;

        return amount != null ? amount.equals(amount1.amount) : amount1.amount == null;
    }

    @Override
    public int hashCode() {
        return amount != null ? amount.hashCode() : 0;
    }
}