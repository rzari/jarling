package org.jarling.v2.models.businesses;

import lombok.Data;

/**
 * Details of a business account holder
 */
@Data
public class Business {
    private String companyName;
    private String companyRegistrationNumber;
    private String email;
    private String phone;
}
