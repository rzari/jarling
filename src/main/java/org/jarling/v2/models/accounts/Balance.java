package org.jarling.v2.models.accounts;

import lombok.Data;

/**
 * Balance details
 */
@Data
public class Balance {
    private CurrencyAndAmount clearedBalance;
    private CurrencyAndAmount effectiveBalance;
    private CurrencyAndAmount pendingTransactions;
    private CurrencyAndAmount availableToSpend;
    private CurrencyAndAmount acceptedOverdraft;
    private CurrencyAndAmount amount;
}
