package org.jarling.v2.models.payments;

import lombok.Data;
import lombok.ToString;
import org.jarling.v2.models.common.CurrencyAndAmount;

import java.util.UUID;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class UpdateStandingOrderRequest {
    UUID paymentOrderUid;

    /**
     * Payment reference
     *
     * minLength: 1
     * maxLength: 18
     * pattern: [a-zA-Z0-9-/?:().,+#=!%&*<>;{\@ "']{1,18}
     * Not null
     */
    String reference;

    CurrencyAndAmount amount;

    StandingOrderRecurrence standingOrderRecurrence;
}
