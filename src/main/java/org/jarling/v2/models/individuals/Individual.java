package org.jarling.v2.models.individuals;

import lombok.Data;

import java.time.LocalDate;

/**
 * Information about an individual account holder
 */
@Data
public class Individual {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String phone;
}
