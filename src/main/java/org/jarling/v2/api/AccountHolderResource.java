package org.jarling.v2.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.accountholder.AccountHolder;

public interface AccountHolderResource {

    /**
     * Get basic information about the account holder
     *
     * @return AccountHolder
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    AccountHolder getAccountHolder() throws StarlingBankRequestException;

    /**
     * Get name of the account holder
     *
     * @return String
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    String getAccountHolderName() throws StarlingBankRequestException;
}
