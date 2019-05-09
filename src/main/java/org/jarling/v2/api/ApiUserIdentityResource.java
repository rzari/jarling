package org.jarling.v2.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.Identity;
import org.jarling.v2.models.Individual;

public interface ApiUserIdentityResource {

    /**
     * The individual who authorised the application
     *
     * @return Individual
     */
    Individual getAuthorisingIndividual() throws StarlingBankRequestException;

    /**
     * Get current token identity
     * This endpoint returns the permissions you have access to, the time until the token expires and the customer&#x27;s unique identifier.
     *
     * @return Identity
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    Identity getTokenIdentity() throws StarlingBankRequestException;
}
