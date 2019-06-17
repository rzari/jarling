package org.jarling.v2.models.kyc;

import lombok.Data;

import java.time.Instant;

/**
 * KYC result
 */
@Data
public class KycResult {
    private final Instant issuedTimestamp;
    private final String fraudDecision;
    private final String amlDecision;
    private final String bureau;
}
