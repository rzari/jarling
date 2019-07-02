package org.jarling.v2.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.payments.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface PaymentsResource {
    /**
     * Create domestic payment
     *
     * @return UUID the payment order UID
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    UUID createDomesticPayment(UUID accountUid, UUID categoryUid, InstructLocalPaymentRequest paymentRequest) throws StarlingBankRequestException;

    /**
     * Get a standing order
     *
     * @return StandingOrder
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    StandingOrder getStandingOrder(UUID accountUid, UUID categoryUid, UUID standingOrderUid) throws StarlingBankRequestException;

    /**
     * Update a standing order
     *
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    UUID updateStandingOrder(UUID accountUid, UUID categoryUid, UUID standingOrderUid, UpdateStandingOrderRequest updateStandingOrderRequest) throws StarlingBankRequestException;

    /**
     * Cancel a standing order
     *
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    void cancelStandingOrder(UUID accountUid, UUID categoryUid, UUID standingOrderUid) throws StarlingBankRequestException;

    /**
     * List standing orders
     *
     * @return List<StandingOrder>
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    List<StandingOrder> getStandingOrders(UUID accountUid, UUID categoryUid) throws StarlingBankRequestException;

    /**
     * Create a standing order
     *
     * @return UUID the UID of the new standing order
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    UUID createStandingOrder(UUID accountUid, UUID categoryUid, CreateStandingOrderRequest standingOrderRequest) throws StarlingBankRequestException;

    /**
     * List next payment dates of a standing order
     *
     * @return List<LocalDate>
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    List<LocalDate> getUpcomingPayments(UUID accountUid, UUID categoryUid, UUID standingOrderUid) throws StarlingBankRequestException;

    /**
     * List next payment dates of a standing order
     *
     * @param count the maximum number of dates to list
     *
     * @return List<LocalDate>
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    List<LocalDate> getUpcomingPayments(UUID accountUid, UUID categoryUid, UUID standingOrderUid, Integer count) throws StarlingBankRequestException;

    /**
     * Get the payments associated with a payment order
     *
     * @return List<Payment>
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    List<Payment> getPaymentsForPaymentOrder(UUID paymentOrderUid) throws StarlingBankRequestException;

    /**
     * Get a payment order
     *
     * @return PaymentOrder
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    PaymentOrder getPaymentOrder(UUID paymentOrderUid) throws StarlingBankRequestException;

}
