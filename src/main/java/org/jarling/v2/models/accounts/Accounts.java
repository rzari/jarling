package org.jarling.v2.models.accounts;

import lombok.Data;

import java.util.List;

/**
 * The accounts of an account holder
 */
@Data
public class Accounts {
    private List<Account> accounts;
}
