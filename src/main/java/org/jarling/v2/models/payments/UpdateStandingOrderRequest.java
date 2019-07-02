package org.jarling.v2.models.payments;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import org.jarling.v2.models.common.CurrencyAndAmount;

import java.util.UUID;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class UpdateStandingOrderRequest {
    private @NonNull UUID paymentOrderUid;

    /**
     * Payment reference, 1-18 characters
     * Allowed characters: a-zA-Z0-9-/?:().,+#=!%&*<>;@ "'{
     */
    private @NonNull String reference;

    private @NonNull CurrencyAndAmount amount;
    private @NonNull StandingOrderRecurrence standingOrderRecurrence;
}
