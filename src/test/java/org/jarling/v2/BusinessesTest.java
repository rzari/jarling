package org.jarling.v2;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.addresses.Address;
import org.jarling.v2.models.businesses.Business;
import org.junit.Test;

import static org.jarling.TestUtils.assertValidEmail;
import static org.jarling.v2.Validators.assertValid;
import static org.junit.Assert.assertFalse;

public class BusinessesTest extends BaseTest {
    @Test
    public void testBusiness() {
        try {
            Business business = starling.getBusiness();

            assertFalse(business.getCompanyName().isEmpty());
            assertFalse(business.getCompanyRegistrationNumber().isEmpty());
            assertValidEmail(business.getEmail());
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testRegisteredAddress() {
        try {
            Address address = starling.getRegisteredAddress();
            assertValid(address);
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testCorrespondenceAddress() {
        try {
            Address address = starling.getCorrespondenceAddress();
            assertValid(address);
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
