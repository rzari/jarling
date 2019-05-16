package org.jarling.v2.models.addresses;

import lombok.Data;

/**
 * Physical address of customer
 */
@Data
public class Address {
    private String line1;
    private String line2;
    private String line3;
    private String postTown;
    private String postCode;
    private String countryCode; // QQ enum?
}
