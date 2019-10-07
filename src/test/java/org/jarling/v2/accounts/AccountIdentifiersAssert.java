package org.jarling.v2.accounts;

import org.assertj.core.api.AbstractAssert;
import org.jarling.v2.models.accounts.AccountIdentifiers;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class AccountIdentifiersAssert extends AbstractAssert<AccountIdentifiersAssert, AccountIdentifiers> {
    public AccountIdentifiersAssert(AccountIdentifiers actual) {
        super(actual, AccountIdentifiersAssert.class);
    }

    public AccountIdentifiersAssert isValid() {
        isNotNull();

        assertThat(actual.getAccountIdentifier()).isAccountNumber();
        assertThat(actual.getBankIdentifier()).isSortCode();
        assertThat(actual.getBic()).isBic();
        assertThat(actual.getIban()).isIban();

        return this;
    }
}
