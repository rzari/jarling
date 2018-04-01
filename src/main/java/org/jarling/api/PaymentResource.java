package org.jarling.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.models.common.RecurrenceRule;
import org.jarling.models.payments.Payment;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * Interface representing resource to manage and instruct payments on behalf of the customer.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public interface PaymentResource {

    /**
     * <p>List payment orders</p>
     * Returns all the payment orders on the customer account. These may be orders for previous immediate payments or scheduled payment orders for historic or on-going payments.
     * @return a list of all payment orders on the customer account
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Payment API - Starling Bank Developer Docs</a>
     */
    List<Payment> listPayments() throws StarlingBankRequestException;

    /**
     * <p>Make local payment</p>
     * Creates and sends an immediate payment within the UK under the faster payments scheme (foreign payment API to follow at a later time). The recipient of the payment must be a contact of the customer (new contacts can be created using the 'Contacts API').
     * @param destinationAccountUid Unique identifier contact account
     * @param reference Reference for the payment
     * @param amount Payment amount
     * @return a copy of the payment just made or null if it failed
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Payment API - Starling Bank Developer Docs</a>
     */
    Payment makeLocalPayment(String destinationAccountUid, String reference, BigDecimal amount) throws StarlingBankRequestException;

    /**
     * <p>Make scheduled payment</p>
     * Sets up a scheduled payment order to make a future or recurring payment within the UK under the faster payments scheme (foreign payment API to follow at a later time). The recipient of the payment must be a contact of the customer (new contacts can be created using the 'Contacts API').
     * @param destinationAccountUid Unique identifier of the contact account
     * @param reference Reference for the payment
     * @param amount Payment amount
     * @param recurrenceRule Frequency of payment
     * @return a copy of the payment just made or null if it failed
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     * @see <a href="https://developer.starlingbank.com/docs">Payment API - Starling Bank Developer Docs</a>
     */
    Payment makeScheduledPayment(String destinationAccountUid, String reference, BigDecimal amount, RecurrenceRule recurrenceRule) throws StarlingBankRequestException;
}
