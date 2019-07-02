package org.jarling.v2.models.payments;

import lombok.Data;
import lombok.ToString;
import org.jarling.v2.models.common.CurrencyAndAmount;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class StandingOrder {
    private UUID paymentOrderUid;
    private CurrencyAndAmount amount;
    private String reference;
    private UUID payeeUid;
    private StandingOrderRecurrence standingOrderRecurrence;

    private LocalDate nextDate;
    private Instant cancelledAt;
}
