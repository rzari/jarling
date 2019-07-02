package org.jarling.v2.models.payments;

import lombok.Data;
import lombok.ToString;
import org.jarling.v2.models.accounts.CurrencyAndAmount;

import java.util.UUID;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class CreateStandingOrderRequest {
    String externalIdentifier = UUID.randomUUID().toString();
    UUID destinationPayeeAccountUid;
    String reference;
    CurrencyAndAmount amount;
    StandingOrderRecurrence standingOrderRecurrence;
}
