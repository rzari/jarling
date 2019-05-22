package org.jarling.v2.models.accounts;

import lombok.Data;

/**
 * Currency and amount
 */
@Data
public class CurrencyAndAmount {
    private final String currency;
    private final long minorUnits;
}
