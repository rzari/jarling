package org.jarling.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.DirectDebitTransaction;

import java.util.Date;
import java.util.List;

/**
 *
 * Interface representing resource to manage customer direct debit transactions.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public interface TransactionDirectDebitResource {

    /**
     * <p>Get direct debit transaction</p>
     * Returns the full details for a specific direct debit transaction
     * @param id Unique identifier of the transaction
     * @return the specific direct debit transaction details
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Transaction Direct Debit API - Starling Bank Developer Docs</a>
     */
    DirectDebitTransaction getDirectDebitTransaction(String id) throws StarlingBankRequestException;

    /**
     * <p>List direct debit transactions</p>
     * Returns up to the last 100 direct debit transactions for the customer
     * @return a list of the direct debit transaction details
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Transaction Direct Debit API - Starling Bank Developer Docs</a>
     */
    List<DirectDebitTransaction> listDirectDebitTransactions() throws StarlingBankRequestException;

    /**
     * <p>List direct debit transactions between</p>
     * Returns the customer's direct debit transactions over the given interval
     * @param from Date from which the transactions should be fetched
     * @param to Date to which the transactions should be fetched
     * @return a list of the direct debit transaction details between the specified dates
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Transaction Direct Debit API - Starling Bank Developer Docs</a>
     */
    List<DirectDebitTransaction> listDirectDebitTransactions(Date from, Date to) throws StarlingBankRequestException;
}
