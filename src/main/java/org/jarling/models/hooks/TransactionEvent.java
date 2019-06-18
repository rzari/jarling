package org.jarling.models.hooks;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public abstract class TransactionEvent {
    private UUID transactionUid;
    private BigDecimal amount;
    private String sourceCurrency;
    private BigDecimal sourceAmount;
    private String counterParty;
    private String forCustomer;
}
