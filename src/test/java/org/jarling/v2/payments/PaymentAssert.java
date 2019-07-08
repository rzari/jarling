package org.jarling.v2.payments;

import org.assertj.core.api.AbstractAssert;
import org.jarling.v2.models.payments.Payment;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class PaymentAssert extends AbstractAssert<PaymentAssert, Payment> {
    public PaymentAssert(Payment actual) {
        super(actual, PaymentAssert.class);
    }

    public PaymentAssert isValid() {
        isNotNull();

        assertThat(actual.getPaymentUid()).isNotNull();
        assertThat(actual.getAmount()).isNotNull();
        assertThat(actual.getAmount()).isValid().isNotNegative();
        assertThat(actual.getReference()).isNotNull();
        assertThat(actual.getReference()).isValidPaymentReference();
        assertThat(actual.getPayeeUid()).isNotNull();
        assertThat(actual.getPayeeAccountUid()).isNotNull();
        assertThat(actual.getCreatedAt()).isNotNull();

        return this;
    }
}
