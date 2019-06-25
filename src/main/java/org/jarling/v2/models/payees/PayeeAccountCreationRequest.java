package org.jarling.v2.models.payees;

import com.neovisionaries.i18n.CountryCode;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class PayeeAccountCreationRequest {
    private @NonNull String description;
    private boolean defaultAccount;
    /**
     * Country code: currently this **must** be GB.
     */
    private @NonNull CountryCode countryCode = CountryCode.GB;
    private @NonNull String accountIdentifier;
    private @NonNull String bankIdentifier;
    private @NonNull BankIdentifierType bankIdentifierType;
}
