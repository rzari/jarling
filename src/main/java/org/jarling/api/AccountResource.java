package org.jarling.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.Account;
import org.jarling.models.AccountBalance;

/**
 *
 * Interface representing resource to manage the customer's account and query account balance.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public interface AccountResource {

    /**
     * <p>Get account</p>
     * Returns the customer's account information.
     * @return Account
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Account API - Starling Bank Developer Docs</a>
     */
    Account getAccount() throws StarlingBankRequestException;

    /**
     * <p>Get balance</p>
     * Returns the customer's account balance.
     * @return AccountBalance
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Account API - Starling Bank Developer Docs</a>
     */
    AccountBalance getAccountBalance() throws StarlingBankRequestException;
}
