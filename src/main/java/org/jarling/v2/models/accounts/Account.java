package org.jarling.v2.models.accounts;

import lombok.Data;

import java.time.Instant;
import java.util.UUID;

/**
 * Bank account details
 */
@Data
public class Account {
    private final UUID accountUid;
    private final UUID defaultCategory;
    private final String currency;
    private final Instant createdAt;
}
