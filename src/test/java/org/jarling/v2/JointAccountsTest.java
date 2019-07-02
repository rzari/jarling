package org.jarling.v2;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.jointaccounts.JointAccount;
import org.junit.Test;

import static org.jarling.v2.Validators.assertValid;
import static org.junit.Assert.assertNotNull;

public class JointAccountsTest extends BaseTest {
    @Test
    public void testJointAccount() {
        try {
            JointAccount jointAccount = starling.getJointAccount();
            assertNotNull(jointAccount.getAccountHolderUid());
            assertValid(jointAccount.getPersonOne());
            assertValid(jointAccount.getPersonTwo());
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
