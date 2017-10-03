package org.jarling.models;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public enum TransactionStatus {

    PENDING("PENDING"),
    REVERSED("REVERSED"),
    SETTLED("SETTLED"),
    DECLINED("DECLINED"),
    CANCELLED("CANCELLED");

    private final String value;

    TransactionStatus(String value){ this.value = value; }

    public String getValue() {
        return this.value;
    }

}
