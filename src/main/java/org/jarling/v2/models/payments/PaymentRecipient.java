package org.jarling.v2.models.payments;

import com.neovisionaries.i18n.CountryCode;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import org.jarling.v2.models.payees.BankIdentifierType;
import org.jarling.v2.models.payees.PayeeType;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class PaymentRecipient {
    /**
     * Payee name, 1-255 characters
     */
    private @NonNull String payeeName;

    private @NonNull PayeeType payeeType;
    private @NonNull CountryCode countryCode;

    /**
     * Account identifier, e.g. account number. 0-34 characters
     */
    private @NonNull String accountIdentifier;

    /**
     * Bank identifier, e.g. sort code. 0-34 characters
     */
    private @NonNull String bankIdentifier;
    private @NonNull BankIdentifierType bankIdentifierType;
}
