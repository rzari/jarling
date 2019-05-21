package org.jarling.v2.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.addresses.Address;
import org.jarling.v2.models.businesses.Business;

public interface BusinessesResource {

    /**
     * Get a business account holder's details
     *
     * @return Business
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    Business getBusiness() throws StarlingBankRequestException;

    /**
     * Get a company's registered address
     *
     * @return Address
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    Address getRegisteredAddress() throws StarlingBankRequestException;

    /**
     * Get a company's correspondence address. Will fallback to registered address if null.
     *
     * @return Address
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    Address getCorrespondenceAddress() throws StarlingBankRequestException;
}
