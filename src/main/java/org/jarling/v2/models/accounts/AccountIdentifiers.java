package org.jarling.v2.models.accounts;

import lombok.Data;

/**
 * Bank account identifiers
 */
@Data
public class AccountIdentifiers {
    private final String accountIdentifier;
    private final String bankIdentifier;
    private final String iban;
    private final String bic;
}
