package org.jarling.v2.models.apiuseridentity;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;
import java.util.UUID;

/**
 * Identity
 */
@Data
@ToString(onlyExplicitlyIncluded = true)
public class Identity {
    private UUID accountHolderUid;
    private Instant expiresAt;
    private Long expiresInSeconds;
    private String[] scopes;
    private Boolean authenticated;
    private UUID customerUid;
}
