package org.jarling.models.directDebits;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public enum DirectDebitMandateSource {

    ELECTRONIC("ELECTRONIC"),
    PAPER("PAPER");

    private final String value;

    DirectDebitMandateSource(String value){ this.value = value; }

    public String getValue() {
        return this.value;
    }
}
