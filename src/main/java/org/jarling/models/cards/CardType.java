package org.jarling.models.cards;

/**
 * @author Nav Roudsari (nav@rzari.co.uk)
 */
public enum CardType {

    CONTACTLESS_DEBIT_MASTERCARD("ContactlessDebitMastercard"),
    NONE(null);

    private final String value;

    CardType(String value){ this.value = value; }

    public String getValue() {
        return this.value;
    }
}
