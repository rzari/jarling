package org.jarling.v2;

import org.jarling.TestUtils;
import org.jarling.v2.models.addresses.Address;
import org.jarling.v2.models.common.CurrencyAndAmount;
import org.jarling.v2.models.individuals.Individual;
import org.jarling.v2.models.payees.Payee;
import org.jarling.v2.models.payments.StandingOrder;
import org.jarling.v2.models.payments.StandingOrderRecurrence;

import java.time.LocalDate;

import static org.jarling.TestUtils.assertValidEmail;
import static org.junit.Assert.*;

abstract class Validators {
    static void assertValid(CurrencyAndAmount amount) {
        assertNotNull(amount.getCurrency());
        assertValidCurrency(amount.getCurrency());
        assertNotNull(amount.getMinorUnits());
    }

    static void assertValid(StandingOrderRecurrence recurrence) {
        assertNotNull(recurrence.getStartDate());
        assertNotNull(recurrence.getFrequency());
    }

    static void assertValid(StandingOrder standingOrder) {
        assertNotNull(standingOrder.getPaymentOrderUid());
        assertNotNull(standingOrder.getAmount());
        assertValid(standingOrder.getAmount());
        assertValidPaymentReference(standingOrder.getReference());
        assertNotNull(standingOrder.getPayeeUid());
        assertNotNull(standingOrder.getStandingOrderRecurrence());
        assertValid(standingOrder.getStandingOrderRecurrence());
    }

    static void assertValid(Address address) {
        TestUtils.assertValidPostCode(address.getPostCode());
        assertNotNull(address.getLine1());
        assertNotNull(address.getPostTown());
        assertNotNull(address.getCountryCode());
    }

    static void assertValidPaymentReference(String reference) {
        assertTrue(reference.matches("[a-zA-Z0-9-/?:().,+#=!%&*<>;{@ \"']{1,18}"));
    }

    static void assertValidCurrency(String currency) {
        assertEquals(3, currency.length());
    }

    static void assertValidMimeType(String mimeType) {
        assertTrue(mimeType.matches(
            "^(?=[-a-z]{1,127}/[-.a-z0-9]{1,127}$)[a-z]+(-[a-z]+)*/[a-z0-9]+([-.][a-z0-9]+)*$"
        ));
    }

    static void assertValid(Individual individual) {
        assertValidEmail(individual.getEmail());
        assertFalse(individual.getFirstName().isEmpty());
        assertFalse(individual.getLastName().isEmpty());
        assertTrue(individual.getDateOfBirth().isBefore(LocalDate.now()));
    }

    static void assertValid(Payee firstPayee) {
        assertNotNull(firstPayee.getPayeeUid());
        assertNotNull(firstPayee.getPayeeName());
        assertNotNull(firstPayee.getPayeeType());
        assertFalse(firstPayee.getAccounts().isEmpty());
    }
}
