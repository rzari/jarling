package org.jarling.v2.kyc;

import org.assertj.core.api.AbstractAssert;
import org.jarling.v2.models.kyc.KycResult;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

public class KycResultAssert extends AbstractAssert<KycResultAssert, KycResult> {
    public KycResultAssert(KycResult actual) {
        super(actual, KycResultAssert.class);
    }

    public KycResultAssert isValid() {
        isNotNull();
        assertThat(actual.getAmlDecision()).isNotEmpty();
        assertThat(actual.getIssuedTimestamp()).isBefore(Instant.now());
        return this;
    }
}
