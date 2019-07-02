package org.jarling.v2;

import org.jarling.v2.models.accounts.CurrencyAndAmount;
import org.jarling.v2.models.payments.StandingOrder;
import org.jarling.v2.models.payments.StandingOrderRecurrence;

import static org.junit.Assert.*;

public class TestUtils {
    public static void assertValid(CurrencyAndAmount amount) {
        assertNotNull(amount.getCurrency());
        assertEquals(3, amount.getCurrency().length());
        assertNotNull(amount.getMinorUnits());
    }

    public static void assertValid(StandingOrderRecurrence recurrence) {
        assertNotNull(recurrence.getStartDate());
        assertNotNull(recurrence.getFrequency());
    }

    public static void assertValid(StandingOrder standingOrder) {
        assertNotNull(standingOrder.getPaymentOrderUid());
        assertNotNull(standingOrder.getAmount());
        assertValid(standingOrder.getAmount());
        assertValidPaymentReference(standingOrder.getReference());
        assertNotNull(standingOrder.getPayeeUid());
        assertNotNull(standingOrder.getStandingOrderRecurrence());
        assertValid(standingOrder.getStandingOrderRecurrence());
    }

    public static void assertValidPaymentReference(String reference) {
        assertTrue(reference.matches("[a-zA-Z0-9-/?:().,+#=!%&*<>;{@ \"']{1,18}"));
    }
}


