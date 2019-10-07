package org.jarling.v2.jointaccounts;

import org.assertj.core.api.AbstractAssert;
import org.jarling.v2.models.jointaccounts.JointAccount;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class JointAccountAssert extends AbstractAssert<JointAccountAssert, JointAccount> {
    public JointAccountAssert(JointAccount actual) {
        super(actual, JointAccountAssert.class);
    }


    public JointAccountAssert isValid() {
        isNotNull();

        assertThat(actual.getAccountHolderUid()).isNotNull();
        assertThat(actual.getPersonOne()).as("Person One").isValid();
        assertThat(actual.getPersonTwo()).as("Person Two").isValid();

        return this;
    }
}
