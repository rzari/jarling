package org.jarling.v2.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.addresses.Address;
import org.jarling.v2.models.businesses.Business;

public interface BusinessesResource {

    /**
     * Get a business account holder's details
     */
    Business getBusiness() throws StarlingBankRequestException;

    /**
     * Get a company's registered address
     */
    Address getRegisteredAddress() throws StarlingBankRequestException;

    /**
     * Get a company's correspondence address. Will fallback to registered address if null.
     */
    Address getCorrespondenceAddress() throws StarlingBankRequestException;
}
