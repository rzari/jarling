package org.jarling.models.transactions;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public enum MasterCardTransactionMethod {

    CONTACTLESS("CONTACTLESS"),
    MAGNETIC_STRIP("MAGNETIC_STRIP"),
    MANUAL_KEY_ENTRY("MANUAL_KEY_ENTRY"),
    CHIP_AND_PIN("CHIP_AND_PIN"),
    ONLINE("ONLINE"),
    ATM("ATM"),
    APPLE_PAY("APPLE_PAY"),
    ANDROID_PAY("ANDROID_PAY"),
    NOT_APPLICABLE("NOT_APPLICABLE"),
    UNKNOWN("UNKNOWN");

    private final String value;

    MasterCardTransactionMethod(String value){ this.value = value; }

    public String getValue() {
        return this.value;
    }
}
