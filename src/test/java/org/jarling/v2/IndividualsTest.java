package org.jarling.v2;

import org.jarling.TestUtils;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.individuals.Individual;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IndividualsTest extends BaseTest {
    @Test
    public void testIndividual() {
        try {
            Individual individual = starling.getIndividual();
            assertTrue(individual.getEmail().matches(TestUtils.regexEmail));
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
