package org.jarling.v2.payments;

import com.neovisionaries.i18n.CountryCode;
import com.neovisionaries.i18n.CurrencyCode;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.BaseTest;
import org.jarling.v2.models.accounts.Account;
import org.jarling.v2.models.common.CurrencyAndAmount;
import org.jarling.v2.models.payees.BankIdentifierType;
import org.jarling.v2.models.payees.PayeeType;
import org.jarling.v2.models.payments.*;
import org.junit.Test;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assumptions.assumeThat;
import static org.jarling.v2.JarlingAssertions.assertThat;

public class PaymentsTest extends BaseTest {

    @Test
    public void testCreateDomesticPaymentWithExistingPayee() {
        try {
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

            UUID paymentUid = starling.createDomesticPayment(accountUid, categoryUid, paymentRequest);

            assertThat(paymentUid).isNotNull();

            PaymentOrder paymentOrder = starling.getPaymentOrder(paymentUid);
            assertThat(paymentOrder).hasPaymentOrderUid(paymentUid);
            assertThat(paymentOrder).isValid();
            assertThat(paymentOrder).matches(paymentRequest);
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test(expected = StarlingBankRequestException.class)
    public void testCreateDomesticPaymentWithInsufficientFunds() throws StarlingBankRequestException {
        Account account = starling.getAccounts().get(0);
        CurrencyAndAmount currencyAndAmount =
                starling.getAccountBalance(account.getAccountUid()).getAvailableToSpend();
        UUID accountUid = account.getAccountUid();
        UUID categoryUid = account.getDefaultCategory();
        UUID destinationAccountUid = starling
                .getPayees().get(0)
                .getAccounts().get(0)
                .getPayeeAccountUid();

        InstructLocalPaymentRequest paymentRequest = new InstructLocalPaymentRequest(
                "Ref",
                new CurrencyAndAmount(CurrencyCode.GBP, currencyAndAmount.getMinorUnits().add(BigInteger.ONE)),
                destinationAccountUid
        );
        starling.createDomesticPayment(accountUid, categoryUid, paymentRequest);
    }

    @Test
    public void testCreateDomesticPaymentWithNewPayee() {
        try {
            assumeThat(externalAccountNumber)
                .withFailMessage("Please configure an account number and sort code in sandbox.properties")
                .isNotBlank();
            assumeThat(externalAccountNumber)
                .withFailMessage("Please configure an account number and sort code in sandbox.properties")
                .isNotBlank();


            Account account = starling.getAccounts().get(0);
            UUID accountUid = account.getAccountUid();
            UUID categoryUid = account.getDefaultCategory();
            PaymentRecipient paymentRecipient = new PaymentRecipient(
                "Franklin Shepard",
                PayeeType.BUSINESS,
                CountryCode.GB,
                externalAccountNumber,
                externalSortCode,
                BankIdentifierType.SORT_CODE
            );
            InstructLocalPaymentRequest paymentRequest = new InstructLocalPaymentRequest(
                "Ref",
                createCurrencyAndAmount(),
                paymentRecipient
            );

            UUID paymentUid = starling.createDomesticPayment(accountUid, categoryUid, paymentRequest);

            assertThat(paymentUid).isNotNull();

            PaymentOrder paymentOrder = starling.getPaymentOrder(paymentUid);
            assertThat(paymentOrder).hasPaymentOrderUid(paymentUid);
            assertThat(paymentOrder).isValid();
            assertThat(paymentOrder).matches(paymentRequest);
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
            assertThat(standingOrderUid).isNotNull();
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

            assumeThat(standingOrders.isEmpty()).isFalse();
            standingOrders.forEach(order -> assertThat(order).isValid());
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

            assumeThat(standingOrders).isNotEmpty();

            StandingOrder standingOrder = starling.getStandingOrder(
                accountUid,
                categoryUid,
                standingOrders.get(0).getPaymentOrderUid()
            );

            assertThat(standingOrder).isValid();
            assertThat(standingOrders.get(0)).isEqualTo(standingOrder);
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
            assumeThat(standingOrders).isNotEmpty();
            StandingOrder standingOrder = standingOrders.get(0);


            UpdateStandingOrderRequest request = new UpdateStandingOrderRequest(
                standingOrder.getPaymentOrderUid(),
                "updated reference",
                createCurrencyAndAmount(),
                createStandingOrderRecurrence()
            );

            UUID standingOrderUid = starling.updateStandingOrder(accountUid, categoryUid, standingOrder.getPaymentOrderUid(), request);

            assertThat(standingOrderUid)
                .isNotNull()
                .isNotEqualTo(standingOrder.getPaymentOrderUid());

            StandingOrder updatedStandingOrder = starling.getStandingOrder(
                accountUid,
                categoryUid,
                standingOrderUid
            );

            assertThat(updatedStandingOrder).matches(request);
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
            assumeThat(standingOrders).isNotEmpty();
            StandingOrder standingOrder = standingOrders.get(0);

            starling.cancelStandingOrder(accountUid, categoryUid, standingOrder.getPaymentOrderUid());

            StandingOrder cancelledStandingOrder = starling.getStandingOrder(accountUid, categoryUid, standingOrder.getPaymentOrderUid());

            assertThat(cancelledStandingOrder).isCancelled();
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
            assumeThat(standingOrders).isNotEmpty();
            StandingOrder standingOrder = standingOrders.get(0);

            List<LocalDate> upcomingPayments = starling.getUpcomingPayments(accountUid, categoryUid, standingOrder.getPaymentOrderUid());
            assumeThat(upcomingPayments).isNotEmpty();
            upcomingPayments.forEach(
                date -> assertThat(date).isAfterOrEqualTo(LocalDate.now())
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
            assertThat(payments).isNotEmpty();
            payments.forEach(payment -> assertThat(payment).isValid());
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
