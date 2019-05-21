package org.jarling.v2;

import org.jarling.v2.api.AccountHolderResource;
import org.jarling.v2.api.AddressesResource;
import org.jarling.v2.api.ApiUserIdentityResource;
import org.jarling.v2.api.BusinessesResource;

public interface StarlingBank extends AccountHolderResource, AddressesResource, ApiUserIdentityResource, BusinessesResource {
    AccountHolderResource accountHolder();
    AddressesResource addresses();
    ApiUserIdentityResource identity();
    BusinessesResource businesses();
}
