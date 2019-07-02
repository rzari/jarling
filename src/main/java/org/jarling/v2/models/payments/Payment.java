package org.jarling.v2.models.payments;

import lombok.Data;
import lombok.ToString;
import org.jarling.v2.models.accounts.CurrencyAndAmount;

import java.time.Instant;
import java.util.UUID;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class Payment {
    UUID paymentUid;
    CurrencyAndAmount amount;
    String reference;
    UUID payeeUid;
    UUID payeeAccountUid;
    Instant createdAt;

    Instant completedAt;
    Instant rejectedAt;
    PaymentStatusDetails paymentStatusDetails;
}
