package org.jarling.v2.accounts;

import org.assertj.core.api.AbstractAssert;
import org.jarling.v2.models.accounts.ConfirmationOfFunds;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class ConfirmationOfFundsAssert extends AbstractAssert<ConfirmationOfFundsAssert, ConfirmationOfFunds> {
    public ConfirmationOfFundsAssert(ConfirmationOfFunds actual) {
        super(actual, ConfirmationOfFundsAssert.class);
    }

    public ConfirmationOfFundsAssert isAmountRequestedAvailableToSpend() {
        isNotNull();

        assertThat(actual.isRequestedAmountAvailableToSpend()).isTrue();

        return this;
    }

    public ConfirmationOfFundsAssert isAmountRequestedNotAvailableToSpend() {
        isNotNull();

        assertThat(actual.isRequestedAmountAvailableToSpend()).isFalse();

        return this;
    }
}
