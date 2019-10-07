package org.jarling.v2.models.payments;

import lombok.Getter;

@Getter
public enum PaymentStatus {
    ACCEPTED("ACCEPTED"),
    REEJCTED("REJECTED");

    private final String value;

    PaymentStatus(String value) {
        this.value = value;
    }
}
