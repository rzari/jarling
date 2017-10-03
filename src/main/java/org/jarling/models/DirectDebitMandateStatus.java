package org.jarling.models;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public enum DirectDebitMandateStatus {
    CANCELLED("CANCELLED"),
    LIVE("LIVE");

    private final String value;

    DirectDebitMandateStatus(String value){ this.value = value; }

    public String getValue() {
        return this.value;
    }
}
