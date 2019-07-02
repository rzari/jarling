package org.jarling.v2;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.models.payees.*;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.jarling.v2.Validators.assertValid;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeFalse;

public class PayeesTest extends BaseTest {
    @Test
    public void testGetPayees() {
        try {
            List<Payee> payees = starling.getPayees();
            assumeFalse(payees.isEmpty());

            Payee firstPayee = payees.get(0);

            assertValid(firstPayee);
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testCreatePayee() {
        try {
            PayeeCreationRequest payeeCreation = new PayeeCreationRequest("Ashley Wilding", PayeeType.INDIVIDUAL);
            payeeCreation.setPhoneNumber("01234567890");
            payeeCreation.setFirstName("Ashley");
            payeeCreation.setMiddleName("Rowan");
            payeeCreation.setLastName("Wilding");
            payeeCreation.setBusinessName("Paperclips Inc.");
            payeeCreation.setDateOfBirth(LocalDate.now());

            PayeeAccountCreationRequest accountCreation = new PayeeAccountCreationRequest("First Account", "72170713", "608371", BankIdentifierType.SORT_CODE);
            accountCreation.setDefaultAccount(true);

            payeeCreation.setAccounts(Collections.singletonList(accountCreation));

            UUID newPayeeUuid = starling.createPayee(payeeCreation);

            assertNotNull(newPayeeUuid);

            List<Payee> payees = starling.getPayees();

            List<Payee> relevantPayeeList = payees.stream()
                .filter(payee -> payee.getPayeeUid().equals(newPayeeUuid))
                .collect(Collectors.toList());
            assertEquals(1, relevantPayeeList.size());

            Payee payee = relevantPayeeList.get(0);
            assertMatching(payeeCreation, payee);
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    private static void assertMatching(PayeeCreationRequest payeeCreation, Payee payee) {
        assertEquals(payeeCreation.getPayeeName(), payee.getPayeeName());
        assertEquals(payeeCreation.getPayeeType(), payee.getPayeeType());
        assertEquals(payeeCreation.getPhoneNumber(), payee.getPhoneNumber());
        assertEquals(payeeCreation.getFirstName(), payee.getFirstName());
        assertEquals(payeeCreation.getMiddleName(), payee.getMiddleName());
        assertEquals(payeeCreation.getLastName(), payee.getLastName());
        assertEquals(payeeCreation.getBusinessName(), payee.getBusinessName());
        assertEquals(payeeCreation.getDateOfBirth(), payee.getDateOfBirth());

        assertEquals(payeeCreation.getAccounts().size(), payee.getAccounts().size());

        IntStream.range(0, payee.getAccounts().size()).forEach(i -> {
            PayeeAccountCreationRequest creationRequest = payeeCreation.getAccounts().get(i);
            PayeeAccount account = payee.getAccounts().get(i);
            assertMatching(creationRequest, account);
        });
    }

    @Test
    public void testCreatePayeeAccount() {
        try {
            List<Payee> payees = starling.getPayees();

            assumeFalse(payees.isEmpty());

            Payee payee = payees.get(0);
            PayeeAccountCreationRequest accountCreation = new PayeeAccountCreationRequest("First Account", "36094748", "608371", BankIdentifierType.SORT_CODE);

            UUID payeeAccount = starling.createPayeeAccount(payee.getPayeeUid(), accountCreation);
            assertNotNull(payeeAccount);

            List<Payee> newPayees = starling.getPayees();
            Payee newPayee = newPayees.get(0);
            List<PayeeAccount> accounts = newPayee.getAccounts().stream()
                .filter(account -> account.getPayeeAccountUid().equals(payeeAccount))
                .collect(Collectors.toList());

            assertFalse(accounts.isEmpty());

            PayeeAccount createdAccount = accounts.get(0);

            assertMatching(accountCreation, createdAccount);
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    private static void assertMatching(PayeeAccountCreationRequest creationRequest, PayeeAccount account) {
        assertEquals(creationRequest.getDescription(), account.getDescription());
        assertEquals(creationRequest.isDefaultAccount(), account.isDefaultAccount());
        assertEquals(creationRequest.getCountryCode(), account.getCountryCode());
        assertEquals(creationRequest.getAccountIdentifier(), account.getAccountIdentifier());
        assertEquals(creationRequest.getBankIdentifier(), account.getBankIdentifier());
        assertEquals(creationRequest.getBankIdentifierType(), account.getBankIdentifierType());
    }

}
