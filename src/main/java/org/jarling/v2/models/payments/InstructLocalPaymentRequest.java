package org.jarling.v2.models.payments;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import org.jarling.v2.models.common.CurrencyAndAmount;

import java.util.UUID;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class InstructLocalPaymentRequest {
    /**
     * A unique identifier to ensure idempotency
     */
    private @NonNull String externalIdentifier = UUID.randomUUID().toString();

    /**
     * Payment reference, 1-18 characters
     * Allowed characters: a-zA-Z0-9-/?:().,+#=!%&*<>;@ "'{
     */
    private @NonNull String reference;

    private @NonNull CurrencyAndAmount amount;

    /**
     * The destination account. Must reference an existing PayeeAccount.
     *
     * Must be present if paymentRecipient is absent.
     */
    private UUID destinationPayeeAccountUid;

    /**
     * The destination account.
     *
     * Must be present if destinationPayeeAccountUid is absent.
     */
    private PaymentRecipient paymentRecipient;

    public InstructLocalPaymentRequest(
        @NonNull String reference,
        @NonNull CurrencyAndAmount amount,
        @NonNull UUID destinationPayeeAccountUid
    ) {
        this.reference = reference;
        this.amount = amount;
        this.destinationPayeeAccountUid = destinationPayeeAccountUid;
    }

    public InstructLocalPaymentRequest(
        @NonNull String reference,
        @NonNull CurrencyAndAmount amount,
        @NonNull PaymentRecipient paymentRecipient
    ) {
        this.reference = reference;
        this.amount = amount;
        this.paymentRecipient = paymentRecipient;
    }
}
