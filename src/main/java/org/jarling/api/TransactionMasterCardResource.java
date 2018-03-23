package org.jarling.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.transactions.MasterCardTransaction;

import java.util.Date;
import java.util.List;

/**
 *
 * Interface representing resource to manage customer card transactions.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public interface TransactionMasterCardResource {

    /**
     * <p>Get mastercard transaction</p>
     * Returns the full details for a specific mastercard transaction
     * @param id Unique identifier of the transaction
     * @return the specific mastercard transaction details
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Transaction Mastercard API - Starling Bank Developer Docs</a>
     */
    MasterCardTransaction getMasterCardTransaction(String id) throws StarlingBankRequestException;

    /**
     * <p>List mastercard transactions</p>
     * Returns up to the last 100 mastercard transactions for the customer
     * @return a list of the mastercard transaction details
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Transaction Mastercard API - Starling Bank Developer Docs</a>
     */
    List<MasterCardTransaction> listMasterCardTransactions() throws StarlingBankRequestException;

    /**
     * <p>List mastercard transactions between</p>
     * Returns the customer's mastercard transactions over the given interval
     * @param from Date from which the transactions should be fetched
     * @param to Date from which the transactions should be fetched
     * @return a list of the mastercard transaction details between the specified dates
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Transaction Mastercard API - Starling Bank Developer Docs</a>
     */
    List<MasterCardTransaction> listMasterCardTransactions(Date from, Date to) throws StarlingBankRequestException;
}
