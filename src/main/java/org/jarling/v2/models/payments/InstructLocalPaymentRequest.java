package org.jarling.v2.models.payments;

import lombok.Data;
import lombok.ToString;
import org.jarling.v2.models.common.CurrencyAndAmount;

import java.util.UUID;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class InstructLocalPaymentRequest {
    /**
     * A unique identifier to ensure idempotency
     * Not null
     */
    String externalIdentifier = UUID.randomUUID().toString();

    /**
     * Payment reference
     * <p>
     * minLength: 1
     * maxLength: 18
     * pattern: [a-zA-Z0-9-/?:().,+#=!%&*<>;{\@ "']{1,18}
     * Not null
     */
    String reference;

    /**
     * Payment amount
     * Not null
     */
    CurrencyAndAmount amount;

    /**
     * The destination account. Must reference an existing PayeeAccount.
     */
    UUID destinationPayeeAccountUid;

    /**
     * The destination account.
     */
    PaymentRecipient paymentRecipient;
}
