package org.jarling.v2.models.accounts;

import com.neovisionaries.i18n.CurrencyCode;
import lombok.Data;
import lombok.ToString;

import java.time.Instant;
import java.util.UUID;

/**
 * Bank account details
 */
@Data
@ToString(onlyExplicitlyIncluded = true)
public class Account {
    private UUID accountUid;
    private UUID defaultCategory;
    private CurrencyCode currency;
    private Instant createdAt;
}
