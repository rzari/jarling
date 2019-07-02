package org.jarling.v2.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.kyc.KycResult;

public interface KycResource {

    /**
     * Get KYC result for a customer
     *
     * Requires request signing
     *
     * @return JointAccount
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    KycResult getKycResult() throws StarlingBankRequestException;
}
