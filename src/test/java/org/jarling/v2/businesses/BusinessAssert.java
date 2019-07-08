package org.jarling.v2.businesses;

import org.assertj.core.api.AbstractAssert;
import org.jarling.v2.models.businesses.Business;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class BusinessAssert extends AbstractAssert<BusinessAssert, Business> {
    public BusinessAssert(Business actual) {
        super(actual, BusinessAssert.class);
    }


    public BusinessAssert isValid() {
        isNotNull();

        assertThat(actual.getCompanyName()).isNotEmpty();
        assertThat(actual.getCompanyRegistrationNumber()).isNotEmpty();
        assertThat(actual.getEmail()).isEmail();

        return this;
    }
}
