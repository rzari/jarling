package org.jarling.models.hooks;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@ToString(onlyExplicitlyIncluded = true)
public abstract class TransactionEvent {
    private UUID transactionUid;
    private BigDecimal amount;
    private String sourceCurrency;
    private BigDecimal sourceAmount;
    private String counterParty;
    private String forCustomer;
}
