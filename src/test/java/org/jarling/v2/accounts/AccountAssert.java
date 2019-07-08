package org.jarling.v2.accounts;

import org.assertj.core.api.AbstractAssert;
import org.jarling.v2.models.accounts.Account;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountAssert extends AbstractAssert<AccountAssert, Account> {
    public AccountAssert(Account actual) {
        super(actual, AccountAssert.class);
    }

    public AccountAssert isValid() {
        isNotNull();

        assertThat(actual.getAccountUid()).isNotNull();
        assertThat(actual.getDefaultCategory()).isNotNull();
        assertThat(actual.getCurrency()).isNotNull();
        assertThat(actual.getCreatedAt()).isBefore(Instant.now());

        return this;
    }
}
