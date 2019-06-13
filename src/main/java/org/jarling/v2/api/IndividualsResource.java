package org.jarling.v2.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.individuals.Individual;

public interface IndividualsResource {

    /**
     * Get an individual account holder's details
     *
     * @return Individual
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    Individual getIndividual() throws StarlingBankRequestException;

    /**
     * Update an individual account holder's email address
     *
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    void updateEmail(String email) throws StarlingBankRequestException;
}
