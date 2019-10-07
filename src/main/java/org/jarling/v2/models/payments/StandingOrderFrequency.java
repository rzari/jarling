package org.jarling.v2.models.payments;

import lombok.Getter;

@Getter
public enum StandingOrderFrequency {
    DAILY("DAILY"),
    WEEKLY("WEEKLY"),
    MONTHLY("MONTHLY"),
    YEARLY("YEARLY");

    private final String value;

    StandingOrderFrequency(String value) {
        this.value = value;
    }
}
