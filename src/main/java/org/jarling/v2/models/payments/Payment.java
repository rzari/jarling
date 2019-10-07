package org.jarling.v2.models.payments;

import lombok.Data;
import lombok.ToString;
import org.jarling.v2.models.common.CurrencyAndAmount;

import java.time.Instant;
import java.util.UUID;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class Payment {
    private UUID paymentUid;
    private CurrencyAndAmount amount;
    private String reference;
    private UUID payeeUid;
    private UUID payeeAccountUid;
    private Instant createdAt;

    private Instant completedAt;
    private Instant rejectedAt;
    private PaymentStatusDetails paymentStatusDetails;
}
