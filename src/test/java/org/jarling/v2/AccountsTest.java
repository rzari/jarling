package org.jarling.v2;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.accounts.Account;
import org.jarling.v2.models.accounts.AccountIdentifiers;
import org.jarling.v2.models.accounts.Balance;
import org.jarling.v2.models.accounts.ConfirmationOfFunds;
import org.junit.Test;

import java.math.BigInteger;
import java.time.Instant;
import java.util.UUID;

import static org.jarling.TestUtils.*;
import static org.junit.Assert.*;

public class AccountsTest extends BaseTest {
    @Test
    public void testAccounts() {
        try {
            Account account = starling.getAccounts().get(0);
            assertNotNull(account.getAccountUid());
            assertNotNull(account.getDefaultCategory());
            assertNotNull(account.getCurrency());
            assertTrue(account.getCreatedAt().isBefore(Instant.now()));
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testAccountIdentifiers() {
        try {
            UUID accountUid = starling.getAccounts().get(0).getAccountUid();
            AccountIdentifiers accountIdentifiers = starling.getAccountIdentifiers(accountUid);
            assertValidAccountNumber(accountIdentifiers.getAccountIdentifier());
            assertValidSortCode(accountIdentifiers.getBankIdentifier());
            assertValidBic(accountIdentifiers.getBic());
            assertValidIban(accountIdentifiers.getIban());
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testAccountBalance() {
        try {
            UUID accountUid = starling.getAccounts().get(0).getAccountUid();
            Balance balance = starling.getAccountBalance(accountUid);

            Validators.assertValid(balance.getClearedBalance());
            Validators.assertValid(balance.getEffectiveBalance());
            Validators.assertValid(balance.getPendingTransactions());
            Validators.assertValid(balance.getAvailableToSpend());
            Validators.assertValid(balance.getAcceptedOverdraft());
            Validators.assertValid(balance.getAmount());

            assertTrue(balance.getAmount().getMinorUnits().compareTo(BigInteger.ZERO) >= 0);
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

            funds = starling.getConfirmationOfFunds(accountUid, balance.getAvailableToSpend().getMinorUnits().add(BigInteger.ONE));
            assertFalse(funds.isRequestedAmountAvailableToSpend());
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
