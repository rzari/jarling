package org.jarling.v2.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.accountholder.AccountHolder;

public interface AccountHolderResource {

    /**
     * Get basic information about the account holder
     */
    AccountHolder getAccountHolder() throws StarlingBankRequestException;

    /**
     * Get name of the account holder
     */
    String getAccountHolderName() throws StarlingBankRequestException;
}
