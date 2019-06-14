package org.jarling.models.hooks;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class CardTransactionEvent extends TransactionEvent {
    private final UUID merchantUid;
    private final UUID merchantLocationUid;
    private final UUID categoryUid;

    public CardTransactionEvent(
        UUID transactionUid,
        BigDecimal amount,
        String sourceCurrency,
        BigDecimal sourceAmount,
        String counterParty,
        String forCustomer,
        UUID merchantUid,
        UUID merchantLocationUid,
        UUID categoryUid
    ) {
        super(transactionUid, amount, sourceCurrency, sourceAmount, counterParty, forCustomer);
        this.merchantUid = merchantUid;
        this.merchantLocationUid = merchantLocationUid;
        this.categoryUid = categoryUid;
    }
}
