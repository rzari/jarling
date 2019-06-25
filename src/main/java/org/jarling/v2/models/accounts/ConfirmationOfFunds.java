package org.jarling.v2.models.accounts;

import lombok.Data;
import lombok.ToString;

/**
 * Confirmation of funds
 */
@Data
@ToString(onlyExplicitlyIncluded = true)
public class ConfirmationOfFunds {
    private boolean requestedAmountAvailableToSpend;
}
