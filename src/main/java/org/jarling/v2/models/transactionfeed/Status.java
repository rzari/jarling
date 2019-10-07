package org.jarling.v2.models.transactionfeed;

import lombok.Getter;

@Getter
public enum Status {
    UPCOMING("UPCOMING"),
    PENDING("PENDING"),
    REVERSED("REVERSED"),
    SETTLED("SETTLED"),
    DECLINED("DECLINED"),
    REFUNDED("REFUNDED"),
    RETRYING("RETRYING"),
    ACCOUNT_CHECK("ACCOUNT_CHECK");

    private final String value;

    Status(String value){ this.value = value; }
}
