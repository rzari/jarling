package org.jarling.v2;

import org.jarling.TestUtils;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.accountholder.AccountHolder;
import org.jarling.v2.models.accountholder.AccountHolderName;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccountHolderTest extends BaseTest {
    @Test
    public void testAccountHolder() {
        try {
            AccountHolder accountHolder = starling.getAccountHolder();
            assertTrue(accountHolder.getAccountHolderUid().toString().matches(TestUtils.regexUUID));
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testAccountHolderName() {
        try {
            AccountHolderName name = starling.getAccountHolderName();
            assertFalse(name.getAccountHolderName().isEmpty());
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
