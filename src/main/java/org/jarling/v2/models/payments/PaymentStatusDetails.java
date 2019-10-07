package org.jarling.v2.models.payments;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class PaymentStatusDetails {
    PaymentStatus paymentStatus;
    PaymentDescription description;
}
