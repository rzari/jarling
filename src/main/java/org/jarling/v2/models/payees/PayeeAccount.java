package org.jarling.v2.models.payees;

import com.neovisionaries.i18n.CountryCode;
import lombok.Data;

import java.util.UUID;

@Data
public class PayeeAccount {
    private UUID payeeAccountUid;
    private String description;
    private boolean defaultAccount;
    private CountryCode countryCode;
    private String accountIdentifier;
    private String bankIdentifier;
    private BankIdentifierType bankIdentifierType;
}
