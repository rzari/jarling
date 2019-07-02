package org.jarling.v2.models.payments;

import lombok.Data;
import lombok.ToString;
import org.jarling.v2.models.common.CurrencyAndAmount;

import java.util.UUID;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class PaymentOrder {
    UUID paymentOrderUid;
    CurrencyAndAmount amount;
    String reference;
    UUID payeeUid;
    UUID payeeAccountUid;
}
