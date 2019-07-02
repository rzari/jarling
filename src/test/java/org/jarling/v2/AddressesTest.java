package org.jarling.v2;

import com.neovisionaries.i18n.CountryCode;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.addresses.Address;
import org.jarling.v2.models.addresses.AddressUpdateRequest;
import org.jarling.v2.models.addresses.Addresses;
import org.junit.Test;

import java.time.LocalDate;

import static org.jarling.v2.Validators.assertValid;
import static org.junit.Assert.assertEquals;

public class AddressesTest extends BaseTest {
    @Test
    public void testGetAddresses() {
        try {
            Addresses addresses = starling.getAddresses();
            final Address current = addresses.getCurrent();
            assertValid(current);
            addresses.getPrevious().forEach(Validators::assertValid);
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

            assertEquals(addresses.getCurrent().getLine1(), addressUpdateRequest.getLine1());
            assertEquals(addresses.getCurrent().getLine2(), addressUpdateRequest.getLine2());
            assertEquals(addresses.getCurrent().getLine3(), addressUpdateRequest.getLine3());
            assertEquals(addresses.getCurrent().getPostTown(), addressUpdateRequest.getPostTown());
            assertEquals(addresses.getCurrent().getPostCode(), addressUpdateRequest.getPostCode());
            assertEquals(addresses.getCurrent().getCountryCode(), addressUpdateRequest.getCountryCode());
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
