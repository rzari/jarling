package org.jarling.v2.models.payees;

import com.neovisionaries.i18n.CountryCode;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class PayeeAccountCreationRequest {
    /**
     * Description. 1-255 characters.
     */
    private @NonNull String description;

    private boolean defaultAccount = false;

    /**
     * Country code: currently this **must** be GB.
     */
    private @NonNull CountryCode countryCode = CountryCode.GB;

    /**
     * Account identifier. 0-34 characters.
     */
    private @NonNull String accountIdentifier;

    /**
     * Bank identifier. 0-34 characters.
     */
    private @NonNull String bankIdentifier;

    private @NonNull BankIdentifierType bankIdentifierType;
}
