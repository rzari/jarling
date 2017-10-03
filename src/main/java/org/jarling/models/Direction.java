package org.jarling.models;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public enum Direction {
    INBOUND("INBOUND"),
    OUTBOUND("OUTBOUND"),
    NONE("NONE");

    private final String value;

    Direction(String value){ this.value = value; }

    public String getValue() {
        return this.value;
    }
}
