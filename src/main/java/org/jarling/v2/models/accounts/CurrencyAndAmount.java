package org.jarling.v2.models.accounts;

import lombok.Data;

import java.math.BigInteger;

/**
 * Currency and amount
 */
@Data
public class CurrencyAndAmount {
    private final String currency;
    private final BigInteger minorUnits;
}
