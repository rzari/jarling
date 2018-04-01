package org.jarling.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.directDebits.DirectDebitMandate;

import java.util.List;

/**
 *
 * Interface representing resource to manage the customer's direct debit mandates.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public interface DirectDebitMandateResource {

    /**
     * <p>Get direct debit mandate</p>
     * Returns the direct debit mandates for a customer.
     * @param id Unique identifier of the direct debit mandate
     * @return DirectDebitMandate
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Direct Debit Mandate API - Starling Bank Developer Docs</a>
     */
    DirectDebitMandate getDirectDebitMandate(String id) throws StarlingBankRequestException;

    /**
     * <p>List direct debit mandates</p>
     * Returns the direct debit mandates for a customer.
     * @return the direct debit mandate set up for the customer
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Direct Debit Mandate API - Starling Bank Developer Docs</a>
     */
    List<DirectDebitMandate> listDirectDebitMandates() throws StarlingBankRequestException;

    /**
     * <p>Cancel direct debit mandate</p>
     * Cancels the direct debit mandate with the specified identifier.
     * @param id Unique identifier of the direct debit mandate to be cancelled
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Direct Debit Mandate API - Starling Bank Developer Docs</a>
     */
    void cancelDirectDebitMandate(String id) throws StarlingBankRequestException;
}
