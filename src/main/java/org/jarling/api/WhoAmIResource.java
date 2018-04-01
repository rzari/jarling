package org.jarling.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.customers.WhoAmI;

/**
 *
 * Interface representing resource that verifies the OAuth access token and provides a unique identifier for the customer account the token provides access to.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public interface WhoAmIResource {

    /**
     * <p>Who am I</p>
     * Returns the unique identifier for the customer and access scopes available.
     * @return WhoAmI
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Who Am I API - Starling Bank Developer Docs</a>
     */
    WhoAmI getWhoAmI() throws StarlingBankRequestException;
}
