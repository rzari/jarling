package org.jarling.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.customers.Customer;

/**
 *
 * Interface representing resource to manage customer's personal information.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public interface CustomerResource {

    /**
     * <p>Get customer</p>
     * Returns the customer details
     * @return Customer
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Customer API - Starling Bank Developer Docs</a>
     */
    Customer getCustomer() throws StarlingBankRequestException;
}
