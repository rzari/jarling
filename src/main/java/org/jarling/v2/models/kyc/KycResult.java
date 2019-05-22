package org.jarling.v2.models.kyc;

import lombok.Data;

import java.util.Date;

/**
 * KYC result
 */
@Data
public class KycResult {
    private final Date issuedTimestamp;
    private final String fraudDecision;
    private final String amlDecision;
    private final String bureau;
}
