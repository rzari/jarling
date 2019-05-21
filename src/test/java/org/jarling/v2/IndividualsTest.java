package org.jarling.v2;

import org.jarling.TestUtils;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.addresses.AddressUpdateRequest;
import org.jarling.v2.models.addresses.Addresses;
import org.jarling.v2.models.individuals.EmailUpdateRequest;
import org.jarling.v2.models.individuals.Individual;
import org.junit.Test;

import java.time.LocalDate;

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
            EmailUpdateRequest emailUpdateRequest = new EmailUpdateRequest("test@example.com");
            starling.updateEmail(emailUpdateRequest);
            Individual individual = starling.getIndividual();
            assertEquals(individual.getEmail(), emailUpdateRequest.getEmail());
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
