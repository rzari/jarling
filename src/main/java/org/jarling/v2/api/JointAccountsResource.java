package org.jarling.v2.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.jointaccounts.JointAccount;

public interface JointAccountsResource {

    /**
     * Get a joint account holder's details
     *
     * @return JointAccount
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    JointAccount getJointAccount() throws StarlingBankRequestException;
}
