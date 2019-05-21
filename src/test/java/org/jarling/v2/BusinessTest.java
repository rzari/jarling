package org.jarling.v2;

import org.jarling.TestUtils;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.addresses.Address;
import org.jarling.v2.models.businesses.Business;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BusinessTest extends BaseTest {
    @Test
    public void testBusiness() {
        try {
            Business business = starling.getBusiness();
            assertTrue(business.getEmail().matches(TestUtils.regexEmail));
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testRegisteredAddress() {
        try {
            Address address = starling.getRegisteredAddress();
            assertTrue(address.getPostCode().matches(TestUtils.regexPostCode));
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testCorrespondenceAddress() {
        try {
            Address address = starling.getCorrespondenceAddress();
            assertTrue(address.getPostCode().matches(TestUtils.regexPostCode));
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
