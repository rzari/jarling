package org.jarling.v2.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.apiuseridentity.Identity;
import org.jarling.v2.models.individuals.Individual;

public interface ApiUserIdentityResource {

    /**
     * The individual who authorised the application
     */
    Individual getAuthorisingIndividual() throws StarlingBankRequestException;

    /**
     * Get current token identity
     */
    Identity getTokenIdentity() throws StarlingBankRequestException;
}
