package org.jarling.v2.accountholder;

import org.assertj.core.api.AbstractAssert;
import org.jarling.v2.models.accountholder.AccountHolder;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class AccountHolderAssert extends AbstractAssert<AccountHolderAssert, AccountHolder> {
    public AccountHolderAssert(AccountHolder actual) {
        super(actual, AccountHolderAssert.class);
    }

    public AccountHolderAssert isValid() {
        isNotNull();

        assertThat(actual.getAccountHolderUid()).isNotNull();
        assertThat(actual.getAccountHolderType()).isNotNull();

        return this;
    }
}
