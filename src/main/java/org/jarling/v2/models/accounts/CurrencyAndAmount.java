package org.jarling.v2.models.accounts;

import lombok.Data;
import lombok.ToString;

import java.math.BigInteger;

/**
 * Currency and amount
 */
@Data
@ToString(onlyExplicitlyIncluded = true)
public class CurrencyAndAmount {
    private String currency;
    private BigInteger minorUnits;
}
