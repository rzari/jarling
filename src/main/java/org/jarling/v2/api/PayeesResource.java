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
     *
     * @return List<Payee>
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    List<Payee> getPayees() throws StarlingBankRequestException;

    /**
     * Create a payee
     *
     * Requires request signing
     *
     * @return the UUID of the new payee
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    UUID createPayee(PayeeCreationRequest creationRequest) throws StarlingBankRequestException;

    /**
     * Create a payee account
     *
     * Requires request signing
     *
     * @return the UUID of the new payee account
     * @throws StarlingBankRequestException when there was an issue accessing the resource
     */
    UUID createPayeeAccount(UUID payeeUid, PayeeAccountCreationRequest creationRequest) throws StarlingBankRequestException;
}
