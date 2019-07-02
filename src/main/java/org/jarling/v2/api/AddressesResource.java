package org.jarling.v2.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.addresses.AddressUpdateRequest;
import org.jarling.v2.models.addresses.Addresses;

public interface AddressesResource {

    /**
     * List the customer's addresses
     */
    Addresses getAddresses() throws StarlingBankRequestException;

    /**
     * Update the customer's current address
     *
     * Requires request signing
     */
    void updateAddress(AddressUpdateRequest addressUpdateRequest) throws StarlingBankRequestException;
}
