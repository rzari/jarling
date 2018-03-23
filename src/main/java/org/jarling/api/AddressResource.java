package org.jarling.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.addresses.Addresses;

/**
 *
 * Interface representing resource to manage customer addresses.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public interface AddressResource {

    /**
     * <p>Get addresses</p>
     * Returns the customer's address history.
     * @return Addresses
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Address API - Starling Bank Developer Docs</a>
     */
    Addresses getAddresses() throws StarlingBankRequestException;
}
