package org.jarling.models.common;

import java.math.BigDecimal;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class CurrencyAndAmount {

    private String currency = "";
    private BigDecimal minorUnits = new BigDecimal(0);

    public CurrencyAndAmount(){}

    public CurrencyAndAmount(String currency, BigDecimal amount){
        this.currency = currency;
        this.minorUnits = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getMinorUnits() {
        return minorUnits;
    }

    @Override
    public String toString() {
        return "CurrencyAndAmount{" +
                "currency='" + currency + '\'' +
                ", minorUnits=" + minorUnits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrencyAndAmount that = (CurrencyAndAmount) o;

        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        return minorUnits != null ? minorUnits.equals(that.minorUnits) : that.minorUnits == null;
    }

    @Override
    public int hashCode() {
        int result = currency != null ? currency.hashCode() : 0;
        result = 31 * result + (minorUnits != null ? minorUnits.hashCode() : 0);
        return result;
    }
}
