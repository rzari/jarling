package org.jarling.v2.models.accounts;

import lombok.Data;
import lombok.ToString;

/**
 * Bank account identifiers
 */
@Data
@ToString(onlyExplicitlyIncluded = true)
public class AccountIdentifiers {
    private String accountIdentifier;
    private String bankIdentifier;
    private String iban;
    private String bic;
}
