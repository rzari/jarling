package org.jarling.v2.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.kyc.KycResult;

public interface KycResource {

    /**
     * Get KYC result for a customer
     *
     * Requires request signing
     */
    KycResult getKycResult() throws StarlingBankRequestException;
}
