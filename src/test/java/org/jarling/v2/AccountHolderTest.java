package org.jarling.v2;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.accountholder.AccountHolder;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class AccountHolderTest extends BaseTest {
    @Test
    public void testAccountHolder() {
        try {
            AccountHolder accountHolder = starling.getAccountHolder();
            assertNotNull(accountHolder.getAccountHolderUid());
            assertNotNull(accountHolder.getAccountHolderType());
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testAccountHolderName() {
        try {
            String name = starling.getAccountHolderName();
            assertFalse(name.isEmpty());
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
