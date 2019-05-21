package org.jarling.v2.models.businesses;

import lombok.Data;

/**
 * Details of a business account holder
 */
@Data
public class Business {
    private final String companyName;
    private final String companyRegistrationNumber;
    private final String email;
    private final String phone;
}
