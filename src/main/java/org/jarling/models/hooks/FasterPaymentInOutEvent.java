package org.jarling.models.hooks;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
public class FasterPaymentInOutEvent extends TransactionEvent {
    private String reference;
}
