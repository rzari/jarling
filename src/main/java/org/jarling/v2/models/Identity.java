package org.jarling.v2.models;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

/**
 * Identity
 */
@Data
public class Identity {
    private UUID accountHolderUid;
    private Date expiresAt;
    private Long expiresInSeconds;
    private String[] scopes;
    private Boolean authenticated;
    private UUID customerUid;
}
