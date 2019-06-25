package org.jarling.v2.models.kyc;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

/**
 * KYC result
 */
@Data
@ToString(onlyExplicitlyIncluded = true)
public class KycResult {
    private Instant issuedTimestamp;
    private String fraudDecision;
    private String amlDecision;
    private String bureau;
}
