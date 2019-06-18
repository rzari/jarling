package org.jarling.v2.models.accounts;

import lombok.Data;

/**
 * Bank account identifiers
 */
@Data
public class AccountIdentifiers {
    private String accountIdentifier;
    private String bankIdentifier;
    private String iban;
    private String bic;
}
