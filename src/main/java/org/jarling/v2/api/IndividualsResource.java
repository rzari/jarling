package org.jarling.v2.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.individuals.Individual;

public interface IndividualsResource {

    /**
     * Get an individual account holder's details
     */
    Individual getIndividual() throws StarlingBankRequestException;

    /**
     * Update an individual account holder's email address
     *
     * Requires request signing
     */
    void updateEmail(String email) throws StarlingBankRequestException;
}
