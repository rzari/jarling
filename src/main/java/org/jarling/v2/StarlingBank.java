package org.jarling.v2;

import org.jarling.v2.api.AccountHolderResource;
import org.jarling.v2.api.AddressesResource;
import org.jarling.v2.api.ApiUserIdentityResource;

public interface StarlingBank extends AccountHolderResource, AddressesResource, ApiUserIdentityResource {
    AccountHolderResource accountHolder();
    AddressesResource addresses();
    ApiUserIdentityResource identity();
}
