package org.jarling.models.hooks;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public abstract class TransactionEvent {
    private final UUID transactionUid;
    private final BigDecimal amount;
    private final String sourceCurrency;
    private final BigDecimal sourceAmount;
    private final String counterParty;
    private final String forCustomer;
}
