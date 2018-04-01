package org.jarling.models.payments;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public enum PaymentType {
    DIRECT_DEBIT("DIRECT_DEBIT"),
    STANDING_ORDER("WEEKLY");

    private final String value;

    PaymentType(String value){ this.value = value; }

    public String getValue() {
        return this.value;
    }
}
