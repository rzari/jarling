package org.jarling.v2.models.addresses;

import lombok.Data;
import lombok.ToString;

/**
 * Current and previous physical addresses
 */
@Data
@ToString(onlyExplicitlyIncluded = true)
public class Addresses {
    private Address current;
    private Address[] previous;
}
