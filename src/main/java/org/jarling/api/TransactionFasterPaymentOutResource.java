package org.jarling.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.transactions.FasterPaymentsOutTransaction;

import java.util.Date;
import java.util.List;

/**
 *
 * Interface representing resource to manage faster payments sent by the customer to other individuals.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public interface TransactionFasterPaymentOutResource {

    /**
     * <p>Get FPS Out transaction</p>
     * Returns the full details for a specific outbound FPS transaction
     * @param id Unique identifier of the transaction
     * @return the specific FPS outbound transaction detail
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Transaction Faster Payment Out API - Starling Bank Developer Docs</a>
     */
    FasterPaymentsOutTransaction getFasterPaymentsOutTransaction(String id) throws StarlingBankRequestException;

    /**
     * <p>List FPS Out transactions</p>
     * Returns up to the last 100 outbound FPS transactions for the customer
     * @return a list of the FPS outbound transaction details
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Transaction Faster Payment Out API - Starling Bank Developer Docs</a>
     */
    List<FasterPaymentsOutTransaction> listFasterPaymentsOutTransactions() throws StarlingBankRequestException;

    /**
     * <p>List FPS Out transactions between</p>
     * Returns the customer's outbound FPS transactions over the given interval
     * @param from Date from which the transactions should be fetched
     * @param to Date from which the transactions should be fetched
     * @return a list of the FPS outbound transaction details between the specified dates
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Transaction Faster Payment Out API - Starling Bank Developer Docs</a>
     */
    List<FasterPaymentsOutTransaction> listFasterPaymentsOutTransactions(Date from, Date to) throws StarlingBankRequestException;
}
