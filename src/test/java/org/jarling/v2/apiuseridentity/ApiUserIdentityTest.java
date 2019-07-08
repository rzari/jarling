package org.jarling.v2.apiuseridentity;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.BaseTest;
import org.jarling.v2.models.apiuseridentity.Identity;
import org.jarling.v2.models.individuals.Individual;
import org.junit.Test;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class ApiUserIdentityTest extends BaseTest {
    @Test
    public void testAuthorisingIndividual() {
        try {
            Individual individual = starling.getAuthorisingIndividual();
            assertThat(individual).isValid();
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testIdentity() {
        try {
            Identity identity = starling.getTokenIdentity();
            assertThat(identity).isValid();
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
