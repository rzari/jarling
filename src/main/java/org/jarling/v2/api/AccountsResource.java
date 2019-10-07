package org.jarling.v2.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.accounts.Account;
import org.jarling.v2.models.accounts.AccountIdentifiers;
import org.jarling.v2.models.accounts.Balance;
import org.jarling.v2.models.accounts.ConfirmationOfFunds;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

public interface AccountsResource {

    /**
     * Get a customer's bank accounts
     */
    List<Account> getAccounts() throws StarlingBankRequestException;

    /**
     * Get a customer's bank account identifiers
     */
    AccountIdentifiers getAccountIdentifiers(UUID accountUid) throws StarlingBankRequestException;

    /**
     * Get an account balance
     */
    Balance getAccountBalance(UUID accountUid) throws StarlingBankRequestException;

    /**
     * Get whether or not there are available funds for a requested amount
     */
    ConfirmationOfFunds getConfirmationOfFunds(UUID accountUid, BigInteger targetAmountInMinorUnits) throws StarlingBankRequestException;
}
