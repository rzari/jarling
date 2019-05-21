package org.jarling.v2;

import org.jarling.TestUtils;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.apiuseridentity.Identity;
import org.jarling.v2.models.individuals.Individual;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ApiUserIdentityTest extends BaseTest {
    @Test
    public void testAuthorisingIndividual() {
        try {
            Individual individual = starling.getAuthorisingIndividual();
            assertTrue(individual.getEmail().matches(TestUtils.regexEmail));
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testIdentity() {
        try {
            Identity identity = starling.getTokenIdentity();
            assertTrue(identity.getCustomerUid().toString().matches(TestUtils.regexUUID));
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
