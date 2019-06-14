package org.jarling.models.hooks;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class FasterPaymentInOutEvent extends TransactionEvent {
    private final String reference;

    public FasterPaymentInOutEvent(
        UUID transactionUid,
        BigDecimal amount,
        String sourceCurrency,
        BigDecimal sourceAmount,
        String counterParty,
        String forCustomer,
        String reference
    ) {
        super(transactionUid, amount, sourceCurrency, sourceAmount, counterParty, forCustomer);
        this.reference = reference;
    }
}
