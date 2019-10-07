package org.jarling.v2.api;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.payees.Payee;
import org.jarling.v2.models.payees.PayeeAccountCreationRequest;
import org.jarling.v2.models.payees.PayeeCreationRequest;

import java.util.List;
import java.util.UUID;

public interface PayeesResource {
    /**
     * Get an account holder's payees
     */
    List<Payee> getPayees() throws StarlingBankRequestException;

    /**
     * Create a payee
     */
    UUID createPayee(PayeeCreationRequest creationRequest) throws StarlingBankRequestException;

    /**
     * Create a payee account
     */
    UUID createPayeeAccount(UUID payeeUid, PayeeAccountCreationRequest creationRequest) throws StarlingBankRequestException;
}
