package org.jarling.v2.accounts;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.BaseTest;
import org.jarling.v2.models.accounts.Account;
import org.jarling.v2.models.accounts.AccountIdentifiers;
import org.jarling.v2.models.accounts.Balance;
import org.jarling.v2.models.accounts.ConfirmationOfFunds;
import org.junit.Test;

import java.math.BigInteger;
import java.util.UUID;

import static org.jarling.v2.JarlingAssertions.assertThat;


public class AccountsTest extends BaseTest {
    @Test
    public void testAccounts() {
        try {
            Account account = starling.getAccounts().get(0);
            assertThat(account).isValid();
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testAccountIdentifiers() {
        try {
            UUID accountUid = starling.getAccounts().get(0).getAccountUid();
            AccountIdentifiers accountIdentifiers = starling.getAccountIdentifiers(accountUid);
            assertThat(accountIdentifiers).isValid();
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testAccountBalance() {
        try {
            UUID accountUid = starling.getAccounts().get(0).getAccountUid();
            Balance balance = starling.getAccountBalance(accountUid);
            assertThat(balance).isValid();
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
            assertThat(funds).isAmountRequestedAvailableToSpend();

            funds = starling.getConfirmationOfFunds(accountUid, balance.getAvailableToSpend().getMinorUnits().add(BigInteger.ONE));
            assertThat(funds).isAmountRequestedNotAvailableToSpend();
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
