package org.jarling.v2.payments;

import org.assertj.core.api.AbstractAssert;
import org.jarling.v2.models.payments.StandingOrder;
import org.jarling.v2.models.payments.UpdateStandingOrderRequest;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class StandingOrderAssert extends AbstractAssert<StandingOrderAssert, StandingOrder> {
    public StandingOrderAssert(StandingOrder actual) {
        super(actual, StandingOrderAssert.class);
    }

    public StandingOrderAssert isValid() {
        isNotNull();
        assertThat(actual.getPaymentOrderUid()).isNotNull();
        assertThat(actual.getAmount()).isNotNull();
        assertThat(actual.getAmount()).isValid().isNotNegative();
        assertThat(actual.getReference()).isValidPaymentReference();
        assertThat(actual.getPayeeUid()).isNotNull();
        assertThat(actual.getStandingOrderRecurrence()).isNotNull();

        return this;
    }

    public StandingOrderAssert matches(UpdateStandingOrderRequest request) {
        isNotNull();

        assertThat(actual.getReference()).isEqualTo(request.getReference());
        assertThat(actual.getAmount()).isEqualTo(request.getAmount());
        assertThat(actual.getStandingOrderRecurrence()).isEqualTo(request.getStandingOrderRecurrence());

        return this;
    }

    public StandingOrderAssert isCancelled() {
        isNotNull();
        assertThat(actual.getCancelledAt()).isNotNull();
        return this;
    }
}
