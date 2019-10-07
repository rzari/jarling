package org.jarling.v2.models.payees;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class PayeeCreationRequest {
    /**
     * Payee name. 1-255 characters.
     */
    private @NonNull String payeeName;

    private @NonNull PayeeType payeeType;
    private String phoneNumber;

    /**
     * First name. 1-255 characters.
     */
    private String firstName;

    /**
     * Middle name. 1-255 characters.
     */
    private String middleName;

    /**
     * Last name. 1-255 characters.
     */
    private String lastName;

    /**
     * Business name. 1-255 characters.
     */
    private String businessName;
    private LocalDate dateOfBirth;

    /**
     * List of accounts to create for this payee.
     * Min size: 1
     * Max size: 2147483647
     */
    private @NonNull List<PayeeAccountCreationRequest> accounts = new ArrayList<>();
}
