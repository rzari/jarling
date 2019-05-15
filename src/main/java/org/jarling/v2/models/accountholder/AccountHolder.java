package org.jarling.v2.models.accountholder;

import lombok.Data;

import java.util.UUID;

/**
 * Information about the account holder type
 */
@Data
public class AccountHolder {
    private UUID accountHolderUid;
    private AccountHolderType accountHolderType;
}
