package org.jarling.v2;

import com.neovisionaries.i18n.CurrencyCode;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.accounts.Account;
import org.jarling.v2.models.common.CurrencyAndAmount;
import org.jarling.v2.models.payments.*;
import org.junit.Test;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.jarling.v2.Validators.assertValid;
import static org.jarling.v2.Validators.assertValidPaymentReference;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeFalse;

public class PaymentsTest extends BaseTest {

    @Test
    public void testCreateDomesticPaymentWithExistingPayee() {
        try {
            UUID paymentUid = createPaymentOrder();
            assertNotNull(paymentUid);
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testGetPaymentOrder() {
        try {
            UUID paymentOrderUid = createPaymentOrder();
            PaymentOrder order = starling.getPaymentOrder(paymentOrderUid);
            assertEquals(paymentOrderUid, order.getPaymentOrderUid());
            assertValid(order.getAmount());
            assertNotNull(order.getReference());
            assertValidPaymentReference(order.getReference());
            assertNotNull(order.getPayeeUid());
            assertNotNull(order.getPayeeAccountUid());
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testCreateStandingOrder() {
        try {
            Account account = starling.getAccounts().get(0);
            UUID accountUid = account.getAccountUid();
            UUID categoryUid = account.getDefaultCategory();

            UUID standingOrderUid = createStandingOrder(accountUid, categoryUid);
            assertNotNull(standingOrderUid);
        } catch (StarlingBankRequestException e) {
            failOnStarlingBankException(e);
        }

    }

    @Test
    public void testGetStandingOrders() {
        try {
            Account account = starling.getAccounts().get(0);
            UUID accountUid = account.getAccountUid();
            UUID categoryUid = account.getDefaultCategory();

            List<StandingOrder> standingOrders = starling.getStandingOrders(accountUid, categoryUid);

            assumeFalse(standingOrders.isEmpty());
            assertValid(standingOrders.get(0));
        } catch (StarlingBankRequestException e) {
            failOnStarlingBankException(e);
        }
    }

    @Test
    public void testGetStandingOrder() {
        try {
            Account account = starling.getAccounts().get(0);
            UUID accountUid = account.getAccountUid();
            UUID categoryUid = account.getDefaultCategory();

            List<StandingOrder> standingOrders = starling.getStandingOrders(accountUid, categoryUid);

            assumeFalse(standingOrders.isEmpty());

            StandingOrder standingOrder = starling.getStandingOrder(accountUid, categoryUid, standingOrders.get(0).getPaymentOrderUid());

            assertValid(standingOrder);
            assertEquals(standingOrder, standingOrders.get(0));
        } catch (StarlingBankRequestException e) {
            failOnStarlingBankException(e);
        }
    }

    @Test
    public void testUpdateStandingOrder() {
        try {
            Account account = starling.getAccounts().get(0);
            UUID accountUid = account.getAccountUid();
            UUID categoryUid = account.getDefaultCategory();

            List<StandingOrder> standingOrders = starling.getStandingOrders(accountUid, categoryUid);
            assumeFalse(standingOrders.isEmpty());
            StandingOrder standingOrder = standingOrders.get(0);


            UpdateStandingOrderRequest request = new UpdateStandingOrderRequest(
                standingOrder.getPaymentOrderUid(),
                "updated reference",
                createCurrencyAndAmount(),
                createStandingOrderRecurrence()
            );

            UUID standingOrderUid = starling.updateStandingOrder(accountUid, categoryUid, standingOrder.getPaymentOrderUid(), request);

            assertNotNull(standingOrderUid);
            assertNotEquals(standingOrder.getPaymentOrderUid(), standingOrderUid);
        } catch (StarlingBankRequestException e) {
            failOnStarlingBankException(e);
        }
    }

    @Test
    public void testCancelStandingOrder() {
        try {
            Account account = starling.getAccounts().get(0);
            UUID accountUid = account.getAccountUid();
            UUID categoryUid = account.getDefaultCategory();

            List<StandingOrder> standingOrders = starling.getStandingOrders(accountUid, categoryUid);
            assumeFalse(standingOrders.isEmpty());
            StandingOrder standingOrder = standingOrders.get(0);

            starling.cancelStandingOrder(accountUid, categoryUid, standingOrder.getPaymentOrderUid());
        } catch (StarlingBankRequestException e) {
            failOnStarlingBankException(e);
        }
    }

    @Test
    public void testGetUpcomingPayments() {
        try {
            Account account = starling.getAccounts().get(0);
            UUID accountUid = account.getAccountUid();
            UUID categoryUid = account.getDefaultCategory();

            List<StandingOrder> standingOrders = starling.getStandingOrders(accountUid, categoryUid)
                .stream()
                .filter(s -> s.getCancelledAt() == null)
                .collect(Collectors.toList());
            assumeFalse(standingOrders.isEmpty());
            StandingOrder standingOrder = standingOrders.get(0);

            List<LocalDate> upcomingPayments = starling.getUpcomingPayments(accountUid, categoryUid, standingOrder.getPaymentOrderUid());
            assertFalse(upcomingPayments.isEmpty());
            upcomingPayments.forEach(
                date -> assertFalse(date.isBefore(LocalDate.now()))
            );
        } catch (StarlingBankRequestException e) {
            failOnStarlingBankException(e);
        }
    }

    @Test
    public void testGetPaymentsForPaymentOrder() {
        try {
            UUID paymentUid = createPaymentOrder();
            List<Payment> payments = starling.getPaymentsForPaymentOrder(paymentUid);
            assertFalse(payments.isEmpty());
            Payment payment = payments.get(0);
            assertNotNull(payment.getPaymentUid());
            assertNotNull(payment.getAmount());
            assertValid(payment.getAmount());
            assertNotNull(payment.getReference());
            assertValidPaymentReference(payment.getReference());
            assertNotNull(payment.getPayeeUid());
            assertNotNull(payment.getPayeeAccountUid());
            assertNotNull(payment.getCreatedAt());
        } catch (StarlingBankRequestException e) {
            failOnStarlingBankException(e);
        }
    }

    private UUID createStandingOrder(UUID accountUid, UUID categoryUid) throws StarlingBankRequestException {
        UUID destinationAccountUid = starling
            .getPayees().get(0)
            .getAccounts().get(0)
            .getPayeeAccountUid();

        CreateStandingOrderRequest request = new CreateStandingOrderRequest(
            destinationAccountUid,
            "Ref",
            createCurrencyAndAmount(),
            createStandingOrderRecurrence()
        );

        return starling.createStandingOrder(accountUid, categoryUid, request);
    }

    private UUID createPaymentOrder() throws StarlingBankRequestException {
        Account account = starling.getAccounts().get(0);
        UUID accountUid = account.getAccountUid();
        UUID categoryUid = account.getDefaultCategory();
        UUID destinationAccountUid = starling
            .getPayees().get(0)
            .getAccounts().get(0)
            .getPayeeAccountUid();

        InstructLocalPaymentRequest paymentRequest = new InstructLocalPaymentRequest(
            "Ref",
            createCurrencyAndAmount(),
            destinationAccountUid
        );

        return starling.createDomesticPayment(accountUid, categoryUid, paymentRequest);

    }

    private static StandingOrderRecurrence createStandingOrderRecurrence() {
        StandingOrderRecurrence recurrence = new StandingOrderRecurrence(
            LocalDate.now(),
            StandingOrderFrequency.DAILY
        );
        recurrence.setInterval(4);
        recurrence.setCount(100);
        recurrence.setUntilDate(null);
        return recurrence;
    }

    private static CurrencyAndAmount createCurrencyAndAmount() {
        return new CurrencyAndAmount(CurrencyCode.GBP, BigInteger.valueOf(123));
    }

}
