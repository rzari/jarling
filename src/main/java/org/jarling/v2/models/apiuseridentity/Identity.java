package org.jarling.v2.models.apiuseridentity;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

/**
 * Identity
 */
@Data
public class Identity {
    private UUID accountHolderUid;
    private Instant expiresAt;
    private Long expiresInSeconds;
    private String[] scopes;
    private Boolean authenticated;
    private UUID customerUid;
}
