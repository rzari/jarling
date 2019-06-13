package org.jarling.v2.models.transactionfeed;

import lombok.Getter;

/**
 * The source subtype of the transaction
 */
@Getter
public enum SourceSubType {
    CONTACTLESS("CONTACTLESS"),
    MAGNETIC_STRIP("MAGNETIC_STRIP"),
    MANUAL_KEY_ENTRY("MANUAL_KEY_ENTRY"),
    CHIP_AND_PIN("CHIP_AND_PIN"),
    ONLINE("ONLINE"),
    ATM("ATM"),
    APPLE_PAY("APPLE_PAY"),
    ANDROID_PAY("ANDROID_PAY"),
    FITBIT_PAY("FITBIT_PAY"),
    GARMIN_PAY("GARMIN_PAY"),
    SAMSUNG_PAY("SAMSUNG_PAY"),
    OTHER_WALLET("OTHER_WALLET"),
    NOT_APPLICABLE("NOT_APPLICABLE"),
    UNKNOWN("UNKNOWN"),
    DEPOSIT("DEPOSIT"),
    OVERDRAFT("OVERDRAFT"),
    SETTLE_UP("SETTLE_UP"),
    NEARBY("NEARBY"),
    TRANSFER_SAME_CURRENCY("TRANSFER_SAME_CURRENCY");

    private final String value;

    SourceSubType(String value){ this.value = value; }
}
