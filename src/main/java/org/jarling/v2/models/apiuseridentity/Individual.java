package org.jarling.v2.models.apiuseridentity;

import lombok.Data;

import java.util.Date;

/**
 * Information about an individual account holder
 */
@Data
public class Individual {
    private final String firstName;
    private final String lastName;
    private final Date dateOfBirth;
    private final String email;
    private final String phone;
}
