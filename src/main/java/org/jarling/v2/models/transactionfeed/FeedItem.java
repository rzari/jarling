package org.jarling.v2.models.transactionfeed;

import com.neovisionaries.i18n.CountryCode;
import lombok.Data;
import org.jarling.v2.models.accounts.CurrencyAndAmount;

import java.time.Instant;
import java.util.UUID;

/**
 * Item in the transaction feed
 */
@Data
public class FeedItem {
    private final UUID feedItemUid;
    private final UUID categoryUid;
    private final CurrencyAndAmount amount;
    private final CurrencyAndAmount sourceAmount;
    private final Direction direction;
    private final Instant updatedAt;
    private final Instant transactionTime;
    private final Instant settlementTime;
    private final Source source;
    private final SourceSubType sourceSubType;
    private final CounterPartyType counterPartyType;
    private final UUID counterPartyUid;
    private final String counterPartyName;
    private final UUID counterPartySubEntityUid;
    private final String counterPartySubEntityName;
    private final String counterPartySubEntityIdentifier;
    private final String counterPartySubEntitySubIdentifier;
    private final String reference;
    private final CountryCode country;
    private final SpendingCategory spendingCategory;
    private final String userNote;
}
