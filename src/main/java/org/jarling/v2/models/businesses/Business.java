package org.jarling.v2.models.businesses;

import lombok.Data;
import lombok.ToString;

/**
 * Details of a business account holder
 */
@Data
@ToString(onlyExplicitlyIncluded = true)
public class Business {
    private String companyName;
    private String companyRegistrationNumber;
    private String email;
    private String phone;
}
