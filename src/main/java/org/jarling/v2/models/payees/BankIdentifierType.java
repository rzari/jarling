package org.jarling.v2.models.payees;

import lombok.Getter;

@Getter
public enum BankIdentifierType {
    SORT_CODE("SORT_CODE"),
    SWIFT("SWIFT"),
    IBAN("IBAN"),
    ABA("ABA"),
    ABA_WIRE("ABA_WIRE"),
    ABA_ACH("ABA_ACH");

    private final String value;

    BankIdentifierType(String value) {
        this.value = value;
    }
}
