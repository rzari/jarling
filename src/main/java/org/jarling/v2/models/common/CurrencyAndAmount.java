package org.jarling.v2.models.common;

import com.neovisionaries.i18n.CurrencyCode;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import java.math.BigInteger;

/**
 * Currency and amount
 */
@Data
@ToString(onlyExplicitlyIncluded = true)
public class CurrencyAndAmount {
    private @NonNull CurrencyCode currency;
    private @NonNull BigInteger minorUnits;
}
