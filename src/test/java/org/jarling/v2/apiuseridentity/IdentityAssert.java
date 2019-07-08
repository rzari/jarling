package org.jarling.v2.apiuseridentity;

import org.assertj.core.api.AbstractAssert;
import org.jarling.v2.models.apiuseridentity.Identity;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class IdentityAssert extends AbstractAssert<IdentityAssert, Identity> {
    public IdentityAssert(Identity actual) {
        super(actual, IdentityAssert.class);
    }

    public IdentityAssert isValid() {
        isNotNull();
        assertThat(actual.getAccountHolderUid()).isNotNull();
        return this;
    }
}
