package org.jarling.v2.models.accounts;

import lombok.Data;
import lombok.ToString;

/**
 * Balance details
 */
@Data
@ToString(onlyExplicitlyIncluded = true)
public class Balance {
    private CurrencyAndAmount clearedBalance;
    private CurrencyAndAmount effectiveBalance;
    private CurrencyAndAmount pendingTransactions;
    private CurrencyAndAmount availableToSpend;
    private CurrencyAndAmount acceptedOverdraft;
    private CurrencyAndAmount amount;
}
