package org.jarling.v2.models.payees;

import lombok.Getter;

@Getter
public enum PayeeType {
    INDIVIDUAL("INDIVIDUAL"),
    BUSINESS("BUSINESS");

    private final String value;

    PayeeType(String value) {
        this.value = value;
    }
}
