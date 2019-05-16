package org.jarling.v2;

import org.jarling.TestUtils;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.accountholder.AccountHolder;
import org.jarling.v2.models.accountholder.AccountHolderName;
import org.jarling.v2.models.addresses.AddressUpdateRequest;
import org.jarling.v2.models.addresses.Addresses;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;

public class AddressesTest extends BaseTest {
    @Test
    public void testGetAddresses() {
        try {
            Addresses addresses = starling.getAddresses();
            assertTrue(addresses.getCurrent().getPostCode().matches(TestUtils.regexPostCode));
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testUpdateAddress() {
        try {
            AddressUpdateRequest addressUpdateRequest = new AddressUpdateRequest("1A Admiralty Arch", "The Mall", "City of Westminster", "London", "SW1A 2WH", "GB", "23748063", "923827402", LocalDate.now());
            starling.updateAddress(addressUpdateRequest);
            Addresses addresses = starling.getAddresses();
            assertEquals(addresses.getCurrent().getPostCode(), addressUpdateRequest.getPostCode());
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
