package org.jarling.v2.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.accounts.*;

import java.util.List;
import java.util.UUID;

public interface AccountsResource {

    /**
     * Get a customer's bank accounts
     *
     * @return Accounts
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    List<Account> getAccounts() throws StarlingBankRequestException;

    /**
     * Get a customer's bank account identifiers
     *
     * @param accountUid Account uid
     * @return AccountIdentifiers
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    AccountIdentifiers getAccountIdentifiers(UUID accountUid) throws StarlingBankRequestException;

    /**
     * Get an account balance
     * The balance of the customer's account is expressed in three ways – cleared balance, effective balance and available to spend. The cleared balance is the settled balance on the account and so does not include pending transactions. The effective balance includes pending transactions, and is the value most commonly presented to the customer.Available to spend is the effective balance plus the amount of accepted overdraft.
     *
     * @param accountUid Account uid
     * @return Balance
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    Balance getAccountBalance(UUID accountUid) throws StarlingBankRequestException;

    /**
     * Get whether or not there are available funds for a requested amount
     *
     * @param accountUid Account uid
     * @param targetAmountInMinorUnits Target amount in minor units
     * @return ConfirmationOfFunds
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    ConfirmationOfFunds getConfirmationOfFunds(UUID accountUid, long targetAmountInMinorUnits) throws StarlingBankRequestException;
}
