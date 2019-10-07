package org.jarling.v2.models.accountholder;

import lombok.Data;
import lombok.ToString;

import java.util.UUID;

/**
 * Information about the account holder type
 */
@Data
@ToString(onlyExplicitlyIncluded = true)
public class AccountHolder {
    private UUID accountHolderUid;
    private AccountHolderType accountHolderType;
}
