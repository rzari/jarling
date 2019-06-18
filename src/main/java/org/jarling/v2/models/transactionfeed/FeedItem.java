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
    private UUID feedItemUid;
    private UUID categoryUid;
    private CurrencyAndAmount amount;
    private CurrencyAndAmount sourceAmount;
    private Direction direction;
    private Instant updatedAt;
    private Instant transactionTime;
    private Instant settlementTime;
    private Source source;
    private SourceSubType sourceSubType;
    private CounterPartyType counterPartyType;
    private UUID counterPartyUid;
    private String counterPartyName;
    private UUID counterPartySubEntityUid;
    private String counterPartySubEntityName;
    private String counterPartySubEntityIdentifier;
    private String counterPartySubEntitySubIdentifier;
    private String reference;
    private CountryCode country;
    private SpendingCategory spendingCategory;
    private String userNote;
}
