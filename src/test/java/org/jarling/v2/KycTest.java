package org.jarling.v2;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.kyc.KycResult;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class KycTest extends BaseTest {
    @Test
    public void testKyc() {
        try {
            KycResult kycResult = starling.getKycResult();
            assertFalse(kycResult.getAmlDecision().isEmpty());
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
