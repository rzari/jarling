package org.jarling.v2.individuals;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.BaseTest;
import org.jarling.v2.models.individuals.Individual;
import org.junit.Test;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class IndividualsTest extends BaseTest {
    @Test
    public void testIndividual() {
        try {
            Individual individual = starling.getIndividual();
            assertThat(individual).isValid();
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testUpdateEmail() {
        try {
            String email = "test@example.com";
            starling.updateEmail(email);
            Individual individual = starling.getIndividual();
            assertThat(individual).hasEmail(email);
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
