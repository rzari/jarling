package org.jarling.v2;

import org.jarling.TestUtils;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.jointaccounts.JointAccount;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JointAccountsTest extends BaseTest {
    @Test
    public void testJointAccount() {
        try {
            JointAccount jointAccount = starling.getJointAccount();
            assertTrue(jointAccount.getAccountHolderUid().toString().matches(TestUtils.regexUUID));
            assertTrue(jointAccount.getPersonOne().getEmail().matches(TestUtils.regexEmail));
            assertTrue(jointAccount.getPersonTwo().getEmail().matches(TestUtils.regexEmail));
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
