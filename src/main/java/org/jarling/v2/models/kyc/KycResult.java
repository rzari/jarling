package org.jarling.v2.models.kyc;

import lombok.Data;

import java.time.Instant;

/**
 * KYC result
 */
@Data
public class KycResult {
    private Instant issuedTimestamp;
    private String fraudDecision;
    private String amlDecision;
    private String bureau;
}
