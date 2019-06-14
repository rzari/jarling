package org.jarling.v2;

import org.jarling.TestUtils;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.accounts.Account;
import org.jarling.v2.models.accounts.AccountIdentifiers;
import org.jarling.v2.models.accounts.Balance;
import org.jarling.v2.models.accounts.ConfirmationOfFunds;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class AccountsTest extends BaseTest {
    @Test
    public void testAccounts() {
        try {
            Account account = starling.getAccounts().get(0);
            assertNotNull(account.getAccountUid());
            assertNotNull(account.getDefaultCategory());
            assertFalse(account.getCurrency().isEmpty());
            assertNotNull(account.getCreatedAt());
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testAccountIdentifiers() {
        try {
            UUID accountUid = starling.getAccounts().get(0).getAccountUid();
            AccountIdentifiers accountIdentifiers = starling.getAccountIdentifiers(accountUid);
            assertTrue(accountIdentifiers.getAccountIdentifier().matches(TestUtils.regexAccountNumber));
            assertTrue(accountIdentifiers.getBankIdentifier().matches(TestUtils.regexSortCode));
            assertTrue(accountIdentifiers.getBic().matches(TestUtils.regexBIC));
            assertTrue(accountIdentifiers.getIban().matches(TestUtils.regexIBAN));
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testAccountBalance() {
        try {
            UUID accountUid = starling.getAccounts().get(0).getAccountUid();
            Balance balance = starling.getAccountBalance(accountUid);
            assertFalse(balance.getAmount().getCurrency().isEmpty());
            assertTrue(balance.getAmount().getMinorUnits() >= 0);
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testConfirmationOfFunds() {
        try {
            UUID accountUid = starling.getAccounts().get(0).getAccountUid();
            Balance balance = starling.getAccountBalance(accountUid);

            ConfirmationOfFunds funds = starling.getConfirmationOfFunds(accountUid, balance.getAvailableToSpend().getMinorUnits());
            assertTrue(funds.isRequestedAmountAvailableToSpend());

            funds = starling.getConfirmationOfFunds(accountUid, balance.getAvailableToSpend().getMinorUnits() + 1);
            assertFalse(funds.isRequestedAmountAvailableToSpend());
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
