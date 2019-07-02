package org.jarling.v2;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.kyc.KycResult;
import org.junit.Test;

import java.time.Instant;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KycTest extends BaseTest {
    @Test
    public void testKyc() {
        try {
            KycResult kycResult = starling.getKycResult();
            assertFalse(kycResult.getAmlDecision().isEmpty());
            assertTrue(kycResult.getIssuedTimestamp().isBefore(Instant.now()));
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
