package org.jarling.v2.models.accountholder;

import lombok.Getter;

@Getter
public enum AccountHolderType {
    INDIVIDUAL("INDIVIDUAL"),
    BUSINESS("BUSINESS"),
    SOLE_TRADER("SOLE_TRADER"),
    JOINT("JOINT"),
    BANKING_AS_A_SERVICE("BANKING_AS_A_SERVICE");

    private final String value;

    AccountHolderType(String value){ this.value = value; }
}
