package org.jarling.v2.models.transactionfeed;

import lombok.Getter;

@Getter
public enum Direction {
    IN("IN"),
    OUT("OUT");

    private final String value;

    Direction(String value){ this.value = value; }
}
