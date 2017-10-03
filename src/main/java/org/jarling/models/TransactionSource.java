package org.jarling.models;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public enum TransactionSource {

    DIRECT_CREDIT("DIRECT_CREDIT"),
    DIRECT_DEBIT("DIRECT_DEBIT"),
    DIRECT_DEBIT_DISPUTE("DIRECT_DEBIT_DISPUTE"),
    INTERNAL_TRANSFER("INTERNAL_TRANSFER"),
    MASTER_CARD("MASTER_CARD"),
    FASTER_PAYMENTS_IN("FASTER_PAYMENTS_IN"),
    FASTER_PAYMENTS_OUT("FASTER_PAYMENTS_OUT"),
    FASTER_PAYMENTS_REVERSAL("FASTER_PAYMENTS_REVERSAL"),
    STRIPE_FUNDING("STRIPE_FUNDING"),
    INTEREST_PAYMENT("INTEREST_PAYMENT"),
    NOSTRO_DEPOSIT("NOSTRO_DEPOSIT"),
    OVERDRAFT("OVERDRAFT");

    private final String value;

    TransactionSource(String value){ this.value = value; }

    public String getValue() {
        return this.value;
    }
}
