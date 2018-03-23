package org.jarling.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.transactions.Transaction;

import java.util.Date;
import java.util.List;

/**
 *
 * Interface representing resource to manage customer transactions.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public interface TransactionResource {

    /**
     * <p>Get transaction</p>
     * Returns the full details for a specific transaction
     * @param id Unique identifier of the transaction
     * @return the specific transaction details
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Transaction API - Starling Bank Developer Docs</a>
     */
    Transaction getTransaction(String id) throws StarlingBankRequestException;

    /**
     * <p>List transactions</p>
     * Returns up to the last 100 transactions for the customer
     * @return a list of the transaction details
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Transaction API - Starling Bank Developer Docs</a>
     */
    List<Transaction> listTransactions() throws StarlingBankRequestException;

    /**
     * <p>List transactions between</p>
     * Returns the customer's transactions over the given interval
     * @param from Date from which the transactions should be fetched
     * @param to Date from which the transactions should be fetched
     * @return a list of the transaction details between the specified dates
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Transaction API - Starling Bank Developer Docs</a>
     */
    List<Transaction> listTransactions(Date from, Date to) throws StarlingBankRequestException;
}
