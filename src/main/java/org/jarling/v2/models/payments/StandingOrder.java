package org.jarling.v2.models.payments;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import org.jarling.v2.models.common.CurrencyAndAmount;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class StandingOrder {
    @NonNull UUID paymentOrderUid;
    @NonNull CurrencyAndAmount amount;
    @NonNull String reference;
    @NonNull UUID payeeUid;
    @NonNull StandingOrderRecurrence standingOrderRecurrence;
    LocalDate nextDate;
    Instant cancelledAt;
}
