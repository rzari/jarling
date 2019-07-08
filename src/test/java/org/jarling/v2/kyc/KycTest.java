package org.jarling.v2.kyc;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.BaseTest;
import org.jarling.v2.models.kyc.KycResult;
import org.junit.Test;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class KycTest extends BaseTest {
    @Test
    public void testKyc() {
        try {
            KycResult kycResult = starling.getKycResult();
            assertThat(kycResult).isValid();
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }
}
