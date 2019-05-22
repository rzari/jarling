package org.jarling.v2.models.accounts;

import lombok.Data;

/**
 * Balance details
 */
@Data
public class Balance {
    private final CurrencyAndAmount clearedBalance;
    private final CurrencyAndAmount effectiveBalance;
    private final CurrencyAndAmount pendingTransactions;
    private final CurrencyAndAmount availableToSpend;
    private final CurrencyAndAmount acceptedOverdraft;
    private final CurrencyAndAmount amount;
}
