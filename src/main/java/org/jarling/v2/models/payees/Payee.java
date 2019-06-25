package org.jarling.v2.models.payees;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * A saved payee of an account holder
 */
@Data
public class Payee {
    private UUID payeeUid;
    private String payeeName;
    private String phoneNumber;
    private PayeeType payeeType;
    private String firstName;
    private String middleName;
    private String lastName;
    private String businessName;
    private LocalDate dateOfBirth;
    private List<PayeeAccount> accounts;
}
