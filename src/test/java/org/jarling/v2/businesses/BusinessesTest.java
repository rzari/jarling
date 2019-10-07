package org.jarling.v2.businesses;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.BaseTest;
import org.jarling.v2.models.addresses.Address;
import org.jarling.v2.models.businesses.Business;
import org.junit.Test;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class BusinessesTest extends BaseTest {
    @Test
    public void testBusiness() {
        try {
            Business business = starling.getBusiness();
            assertThat(business).isValid();
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testRegisteredAddress() {
        try {
            Address address = starling.getRegisteredAddress();
            assertThat(address).isValid();
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testCorrespondenceAddress() {
        try {
            Address address = starling.getCorrespondenceAddress();
            assertThat(address).isValid();
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
