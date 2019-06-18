package org.jarling.v2.models.accounts;

import lombok.Data;

/**
 * Confirmation of funds
 */
@Data
public class ConfirmationOfFunds {
    private boolean requestedAmountAvailableToSpend;
}
