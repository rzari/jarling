package org.jarling.v2.payees;

import org.assertj.core.api.AbstractAssert;
import org.jarling.v2.models.payees.Payee;
import org.jarling.v2.models.payees.PayeeAccount;
import org.jarling.v2.models.payees.PayeeAccountCreationRequest;
import org.jarling.v2.models.payees.PayeeCreationRequest;

import java.util.stream.IntStream;

import static org.jarling.v2.JarlingAssertions.assertThat;


public class PayeeAssert extends AbstractAssert<PayeeAssert, Payee> {
    public PayeeAssert(Payee actual) {
        super(actual, PayeeAssert.class);
    }

    public PayeeAssert isValid() {
        isNotNull();
        assertThat(actual.getPayeeUid()).isNotNull();
        assertThat(actual.getPayeeName()).isNotNull();
        assertThat(actual.getPayeeType()).isNotNull();
        assertThat(actual.getAccounts()).isNotEmpty();

        return this;
    }

    public PayeeAssert matches(PayeeCreationRequest request) {
        isNotNull();

        assertThat(actual.getPayeeName()).isEqualTo(request.getPayeeName());
        assertThat(actual.getPayeeType()).isEqualTo(request.getPayeeType());
        assertThat(actual.getPhoneNumber()).isEqualTo(request.getPhoneNumber());
        assertThat(actual.getFirstName()).isEqualTo(request.getFirstName());
        assertThat(actual.getMiddleName()).isEqualTo(request.getMiddleName());
        assertThat(actual.getLastName()).isEqualTo(request.getLastName());
        assertThat(actual.getBusinessName()).isEqualTo(request.getBusinessName());
        assertThat(actual.getDateOfBirth()).isEqualTo(request.getDateOfBirth());

        assertThat(actual.getAccounts()).hasSameSizeAs(request.getAccounts());

        IntStream.range(0, actual.getAccounts().size()).forEach(i -> {
            PayeeAccountCreationRequest creationRequest = request.getAccounts().get(i);
            PayeeAccount account = actual.getAccounts().get(i);
            assertThat(account).matches(creationRequest);
        });

        return this;
    }
}
