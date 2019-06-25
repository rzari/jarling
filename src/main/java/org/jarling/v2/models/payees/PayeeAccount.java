package org.jarling.v2.models.payees;

import com.neovisionaries.i18n.CountryCode;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class PayeeAccount {
    private UUID payeeAccountUid;
    private String description;
    private boolean defaultAccount;
    private CountryCode countryCode;
    private String accountIdentifier;
    private String bankIdentifier;
    private BankIdentifierType bankIdentifierType;
}
