package org.jarling.v2.models.common;

import com.neovisionaries.i18n.CurrencyCode;
import lombok.*;

import java.math.BigInteger;

/**
 * Currency and amount
 */
@Data
@ToString(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class CurrencyAndAmount {
    private @NonNull CurrencyCode currency = CurrencyCode.UNDEFINED;
    private @NonNull BigInteger minorUnits = BigInteger.ZERO;
}
