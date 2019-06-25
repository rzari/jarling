package org.jarling.v2.models.accountholder;

import lombok.Data;
import lombok.ToString;

/**
 * Name of the account holder
 */
@Data
@ToString(onlyExplicitlyIncluded = true)
public class AccountHolderName {
    private String accountHolderName;
}
