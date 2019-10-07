package org.jarling.v2.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.jointaccounts.JointAccount;

public interface JointAccountsResource {

    /**
     * Get a joint account holder's details
     */
    JointAccount getJointAccount() throws StarlingBankRequestException;
}
