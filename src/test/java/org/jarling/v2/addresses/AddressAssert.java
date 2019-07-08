package org.jarling.v2.addresses;

import org.assertj.core.api.AbstractAssert;
import org.jarling.v2.models.addresses.Address;
import org.jarling.v2.models.addresses.AddressUpdateRequest;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class AddressAssert extends AbstractAssert<AddressAssert, Address> {
    public AddressAssert(Address actual) {
        super(actual, AddressAssert.class);
    }

    public AddressAssert isValid() {
        isNotNull();
        // Starling does not necessarily verify post code format
        assertThat(actual.getPostCode()).isNotNull();
        assertThat(actual.getLine1()).isNotNull();
        assertThat(actual.getPostTown()).isNotNull();
        assertThat(actual.getCountryCode()).isNotNull();

        return this;
    }

    public AddressAssert matches(AddressUpdateRequest request) {
        isNotNull();
        assertThat(request.getLine1()).as("Line 1").isEqualTo(actual.getLine1());
        assertThat(request.getLine2()).as("Line 2").isEqualTo(actual.getLine2());
        assertThat(request.getLine3()).as("Line 3").isEqualTo(actual.getLine3());
        assertThat(request.getPostTown()).as("Post Town").isEqualTo(actual.getPostTown());
        assertThat(request.getPostCode()).as("Post Code").isEqualTo(actual.getPostCode());
        assertThat(request.getCountryCode()).as("Country Code").isEqualTo(actual.getCountryCode());
        return this;
    }
}
