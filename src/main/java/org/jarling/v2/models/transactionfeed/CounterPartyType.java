package org.jarling.v2.models.transactionfeed;

import lombok.Getter;

@Getter
public enum CounterPartyType {
    CATEGORY("CATEGORY"),
    CHEQUE("CHEQUE"),
    CUSTOMER("CUSTOMER"),
    PAYEE("PAYEE"),
    MERCHANT("MERCHANT"),
    SENDER("SENDER"),
    STARLING("STARLING"),
    LOAN("LOAN");

    private String value;

    CounterPartyType(String value) {
        this.value = value;
    }
}
