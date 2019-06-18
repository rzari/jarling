package org.jarling.models.hooks;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FasterPaymentInOutEvent extends TransactionEvent {
    private String reference;
}
