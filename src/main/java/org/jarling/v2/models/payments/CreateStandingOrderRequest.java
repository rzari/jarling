package org.jarling.v2.models.payments;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import org.jarling.v2.models.common.CurrencyAndAmount;

import java.util.UUID;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class CreateStandingOrderRequest {
    /**
     * A unique identifier to ensure idempotency. 0-100 characters.
     */
    private @NonNull String externalIdentifier = UUID.randomUUID().toString();

    /**
     * Destination payee account UID. Contrary to Starling documentation, this cannot be null.
     * See https://starlingdevs.slack.com/archives/C4W4FBWR1/p1561979176142700?thread_ts=1561978894.141800
     */
    private @NonNull UUID destinationPayeeAccountUid;

    /**
     * Payment reference. 1-18 characters.
     * Allowed characters: a-zA-Z0-9-/?:().,+#=!%&*<>;@ "'{
     * */
    private @NonNull String reference;
    private @NonNull CurrencyAndAmount amount;
    private @NonNull StandingOrderRecurrence standingOrderRecurrence;
}
