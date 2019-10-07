package org.jarling.v2.payees;

import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.BaseTest;
import org.jarling.v2.models.payees.*;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assumptions.assumeThat;
import static org.jarling.v2.JarlingAssertions.assertThat;

public class PayeesTest extends BaseTest {
    @Test
    public void testGetPayees() {
        try {
            List<Payee> payees = starling.getPayees();
            assumeThat(payees).isNotEmpty();

            Payee firstPayee = payees.get(0);

            assertThat(firstPayee).isValid();
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

            PayeeAccountCreationRequest accountCreation = new PayeeAccountCreationRequest(
                "First Account",
                "72170713",
                "608371",
                BankIdentifierType.SORT_CODE
            );
            accountCreation.setDefaultAccount(true);

            payeeCreation.setAccounts(Collections.singletonList(accountCreation));

            UUID newPayeeUuid = starling.createPayee(payeeCreation);

            assertThat(newPayeeUuid).isNotNull();

            List<Payee> payees = starling.getPayees();

            List<Payee> relevantPayeeList = payees.stream()
                .filter(payee -> payee.getPayeeUid().equals(newPayeeUuid))
                .collect(Collectors.toList());
            assertThat(relevantPayeeList).hasSize(1);

            Payee payee = relevantPayeeList.get(0);
            assertThat(payee).matches(payeeCreation);
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

    @Test
    public void testCreatePayeeAccount() {
        try {
            List<Payee> payees = starling.getPayees();

            assumeThat(payees).isNotEmpty();

            Payee payee = payees.get(0);
            PayeeAccountCreationRequest accountCreation = new PayeeAccountCreationRequest("First Account", "36094748", "608371", BankIdentifierType.SORT_CODE);

            UUID payeeAccount = starling.createPayeeAccount(payee.getPayeeUid(), accountCreation);
            assertThat(payeeAccount).isNotNull();

            List<Payee> newPayees = starling.getPayees();
            Payee newPayee = newPayees.get(0);
            List<PayeeAccount> accounts = newPayee.getAccounts().stream()
                .filter(account -> account.getPayeeAccountUid().equals(payeeAccount))
                .collect(Collectors.toList());

            assertThat(accounts).isNotEmpty();

            PayeeAccount createdAccount = accounts.get(0);

            assertThat(createdAccount).matches(accountCreation);
        } catch (StarlingBankRequestException se) {
            failOnStarlingBankException(se);
        }
    }

}
