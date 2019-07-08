package org.jarling.v2.addresses;

import com.neovisionaries.i18n.CountryCode;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.BaseTest;
import org.jarling.v2.models.addresses.AddressUpdateRequest;
import org.jarling.v2.models.addresses.Addresses;
import org.junit.Test;

import java.time.LocalDate;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class AddressesTest extends BaseTest {
    @Test
    public void testGetAddresses() {
        try {
            Addresses addresses = starling.getAddresses();
            assertThat(addresses.getCurrent()).isValid();
            addresses.getPrevious().forEach(a -> assertThat(a).isValid());
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testUpdateAddress() {
        try {
            AddressUpdateRequest addressUpdateRequest = new AddressUpdateRequest(
                "1A Admiralty Arch",
                "The Mall",
                "City of Westminster",
                "London",
                "SW1A 2WH",
                CountryCode.GB,
                "23748063",
                "923827402",
                LocalDate.now()
            );

            starling.updateAddress(addressUpdateRequest);
            Addresses addresses = starling.getAddresses();
            assertThat(addresses.getCurrent()).matches(addressUpdateRequest);
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
