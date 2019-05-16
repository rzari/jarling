package org.jarling.v2.models.addresses;

import lombok.Data;

/**
 * Current and previous physical addresses
 */
@Data
public class Addresses {
    private Address current;
    private Address[] previous;
}
