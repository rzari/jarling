package org.jarling.v2.payees;

import org.assertj.core.api.AbstractAssert;
import org.jarling.v2.models.payees.PayeeAccount;
import org.jarling.v2.models.payees.PayeeAccountCreationRequest;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class PayeeAccountAssert extends AbstractAssert<PayeeAccountAssert, PayeeAccount> {
    public PayeeAccountAssert(PayeeAccount actual) {
        super(actual, PayeeAccountAssert.class);
    }

    public PayeeAccountAssert matches(PayeeAccountCreationRequest request) {
        assertThat(actual.getDescription()).isEqualTo(request.getDescription());
        assertThat(actual.isDefaultAccount()).isEqualTo(request.isDefaultAccount());
        assertThat(actual.getCountryCode()).isEqualTo(request.getCountryCode());
        assertThat(actual.getAccountIdentifier()).isEqualTo(request.getAccountIdentifier());
        assertThat(actual.getBankIdentifier()).isEqualTo(request.getBankIdentifier());
        assertThat(actual.getBankIdentifierType()).isEqualTo(request.getBankIdentifierType());

        return this;
    }
}
