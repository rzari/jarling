package org.jarling.v2.jointaccounts;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.BaseTest;
import org.jarling.v2.models.jointaccounts.JointAccount;
import org.junit.Test;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class JointAccountsTest extends BaseTest {
    @Test
    public void testJointAccount() {
        try {
            JointAccount jointAccount = starling.getJointAccount();
            assertThat(jointAccount).isValid();
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
