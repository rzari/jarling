package org.jarling.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.transactions.FasterPaymentsInTransaction;

import java.util.Date;
import java.util.List;

/**
 *
 * Interface representing resource to manage faster payments received by the customer from other individuals.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public interface TransactionFasterPaymentInResource {

    /**
     * <p>Get FPS In transaction</p>
     * Returns the full details for a specific inbound FPS transaction
     * @param id Unique identifier of the transaction
     * @return the specific FPS inbound transaction details
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Transaction Faster Payment In API - Starling Bank Developer Docs</a>
     */
    FasterPaymentsInTransaction getFasterPaymentsInTransaction(String id) throws StarlingBankRequestException;

    /**
     * <p>List FPS In transactions</p>
     * Returns up to the last 100 inbound FPS transactions for the customer
     * @return a list of the FPS inbound transaction details
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Transaction Faster Payment In API - Starling Bank Developer Docs</a>
     */
    List<FasterPaymentsInTransaction> listFasterPaymentsInTransactions() throws StarlingBankRequestException;

    /**
     * <p>List FPS In transactions between</p>
     * Returns the customer's inbound FPS transactions over the given interval
     * @param from Date from which the transactions should be fetched
     * @param to Date from which the transactions should be fetched
     * @return a list of the FPS inbound transaction details between the specified dates
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Transaction Faster Payment In API - Starling Bank Developer Docs</a>
     */
    List<FasterPaymentsInTransaction> listFasterPaymentsInTransactions(Date from, Date to) throws StarlingBankRequestException;
}
