package org.jarling.v2.models.accounts;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

/**
 * Bank account details
 */
@Data
public class Account {
    private UUID accountUid;
    private UUID defaultCategory;
    private String currency;
    private Instant createdAt;
}
