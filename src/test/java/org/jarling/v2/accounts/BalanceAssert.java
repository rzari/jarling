package org.jarling.v2.accounts;

import org.assertj.core.api.AbstractAssert;
import org.jarling.v2.models.accounts.Balance;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class BalanceAssert extends AbstractAssert<BalanceAssert, Balance> {
    public BalanceAssert(Balance actual) {
        super(actual, BalanceAssert.class);
    }

    public BalanceAssert isValid() {
        isNotNull();

        assertThat(actual.getClearedBalance()).isValid().isNotNegative();
        assertThat(actual.getEffectiveBalance()).isValid().isNotNegative();
        assertThat(actual.getPendingTransactions()).isValid().isNotNegative();
        assertThat(actual.getAvailableToSpend()).isValid().isNotNegative();
        assertThat(actual.getAcceptedOverdraft()).isValid().isNotNegative();
        assertThat(actual.getAmount()).isValid().isNotNegative();

        return this;
    }
}
