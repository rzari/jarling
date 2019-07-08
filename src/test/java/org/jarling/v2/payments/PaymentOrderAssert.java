package org.jarling.v2.payments;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;
import org.jarling.v2.models.payments.InstructLocalPaymentRequest;
import org.jarling.v2.models.payments.PaymentOrder;

import java.util.UUID;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class PaymentOrderAssert extends AbstractAssert<PaymentOrderAssert, PaymentOrder> {
    public PaymentOrderAssert(PaymentOrder actual) {
        super(actual, PaymentOrderAssert.class);
    }

    public PaymentOrderAssert isValid() {
        isNotNull();
        assertThat(actual.getAmount()).isValid().isNotNegative();
        assertThat(actual.getReference()).isValidPaymentReference();
        assertThat(actual.getPayeeUid()).isNotNull();
        assertThat(actual.getPayeeAccountUid()).isNotNull();

        return this;
    }

    public PaymentOrderAssert matches(InstructLocalPaymentRequest localPaymentRequest) {
        assertThat(actual.getAmount()).isEqualTo(localPaymentRequest.getAmount());
        assertThat(actual.getReference()).isEqualTo(localPaymentRequest.getReference());

        if (localPaymentRequest.getDestinationPayeeAccountUid() != null) {
            assertThat(localPaymentRequest.getDestinationPayeeAccountUid()).isEqualTo(actual.getPayeeAccountUid());
        }

        return this;
    }

    public PaymentOrderAssert hasPaymentOrderUid(UUID paymentOrderUid) {
        // check that actual PaymentOrder we want to make assertions on is not null.
        isNotNull();

        // overrides the default error message with a more explicit one
        String assertjErrorMessage = "\nExpecting paymentOrderUid of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

        // null safe check
        UUID actualPaymentOrderUid = actual.getPaymentOrderUid();
        if (!Objects.areEqual(actualPaymentOrderUid, paymentOrderUid)) {
            failWithMessage(assertjErrorMessage, actual, paymentOrderUid, actualPaymentOrderUid);
        }

        // return the current assertion for method chaining
        return myself;
    }

    public PaymentOrderAssert hasPayeeUid(UUID payeeUid) {
        // check that actual PaymentOrder we want to make assertions on is not null.
        isNotNull();

        // overrides the default error message with a more explicit one
        String assertjErrorMessage = "\nExpecting payeeUid of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

        // null safe check
        UUID actualPayeeUid = actual.getPayeeUid();
        if (!Objects.areEqual(actualPayeeUid, payeeUid)) {
            failWithMessage(assertjErrorMessage, actual, payeeUid, actualPayeeUid);
        }
        return this;
    }

    public PaymentOrderAssert hasPayeeAccountUid(UUID payeeAccountUid) {
        // check that actual PaymentOrder we want to make assertions on is not null.
        isNotNull();

        // overrides the default error message with a more explicit one
        String assertjErrorMessage = "\nExpecting payeeAccountUid of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

        // null safe check
        UUID actualPayeeAccountUid = actual.getPayeeAccountUid();
        if (!Objects.areEqual(actualPayeeAccountUid, payeeAccountUid)) {
            failWithMessage(assertjErrorMessage, actual, payeeAccountUid, actualPayeeAccountUid);
        }
        return this;
    }
}
