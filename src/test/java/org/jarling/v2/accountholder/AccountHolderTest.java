package org.jarling.v2.accountholder;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.BaseTest;
import org.jarling.v2.models.accountholder.AccountHolder;
import org.junit.Test;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class AccountHolderTest extends BaseTest {
    @Test
    public void testAccountHolder() {
        try {
            AccountHolder accountHolder = starling.getAccountHolder();
            assertThat(accountHolder).isValid();
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testAccountHolderName() {
        try {
            String name = starling.getAccountHolderName();
            assertThat(name).isNotEmpty();
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
