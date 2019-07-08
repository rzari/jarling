package org.jarling.v2.common;

import org.assertj.core.api.AbstractAssert;
import org.jarling.v2.models.common.CurrencyAndAmount;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class CurrencyAndAmountAssert extends AbstractAssert<CurrencyAndAmountAssert, CurrencyAndAmount> {
    public CurrencyAndAmountAssert(CurrencyAndAmount actual) {
        super(actual, CurrencyAndAmountAssert.class);
    }


    public CurrencyAndAmountAssert isValid() {
        isNotNull();

        assertThat(actual.getCurrency()).isNotNull();
        assertThat(actual.getMinorUnits()).isNotNull();

        return this;
    }

    public CurrencyAndAmountAssert isNotNegative() {
        isNotNull();

        assertThat(actual.getMinorUnits()).isNotNegative();

        return this;
    }
}
