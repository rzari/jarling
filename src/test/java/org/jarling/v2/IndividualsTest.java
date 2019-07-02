package org.jarling.v2;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.individuals.Individual;
import org.junit.Test;

import static org.jarling.v2.Validators.assertValid;
import static org.junit.Assert.assertEquals;

public class IndividualsTest extends BaseTest {
    @Test
    public void testIndividual() {
        try {
            Individual individual = starling.getIndividual();
            assertValid(individual);
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
            assertEquals(individual.getEmail(), email);
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
