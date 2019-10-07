package org.jarling.v2.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.payments.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface PaymentsResource {
    /**
     * Create domestic payment
     */
    UUID createDomesticPayment(UUID accountUid, UUID categoryUid, InstructLocalPaymentRequest paymentRequest) throws StarlingBankRequestException;

    /**
     * Get a standing order
     */
    StandingOrder getStandingOrder(UUID accountUid, UUID categoryUid, UUID standingOrderUid) throws StarlingBankRequestException;

    /**
     * Update a standing order
     */
    UUID updateStandingOrder(UUID accountUid, UUID categoryUid, UUID standingOrderUid, UpdateStandingOrderRequest updateStandingOrderRequest) throws StarlingBankRequestException;

    /**
     * Cancel a standing order
     */
    void cancelStandingOrder(UUID accountUid, UUID categoryUid, UUID standingOrderUid) throws StarlingBankRequestException;

    /**
     * List standing orders
     */
    List<StandingOrder> getStandingOrders(UUID accountUid, UUID categoryUid) throws StarlingBankRequestException;

    /**
     * Create a new standing order
     */
    UUID createStandingOrder(UUID accountUid, UUID categoryUid, CreateStandingOrderRequest standingOrderRequest) throws StarlingBankRequestException;

    /**
     * List next payment dates of a standing order
     */
    List<LocalDate> getUpcomingPayments(UUID accountUid, UUID categoryUid, UUID standingOrderUid) throws StarlingBankRequestException;

    /**
     * List next payment dates of a standing order
     *
     * @param count the maximum number of dates to list
     */
    List<LocalDate> getUpcomingPayments(UUID accountUid, UUID categoryUid, UUID standingOrderUid, Integer count) throws StarlingBankRequestException;

    /**
     * Get the payments associated with a payment order
     */
    List<Payment> getPaymentsForPaymentOrder(UUID paymentOrderUid) throws StarlingBankRequestException;

    /**
     * Get a payment order
     */
    PaymentOrder getPaymentOrder(UUID paymentOrderUid) throws StarlingBankRequestException;

}
