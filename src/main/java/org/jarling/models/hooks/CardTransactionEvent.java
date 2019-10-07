package org.jarling.models.hooks;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
public class CardTransactionEvent extends TransactionEvent {
    private UUID merchantUid;
    private UUID merchantLocationUid;
    private UUID categoryUid;
}
