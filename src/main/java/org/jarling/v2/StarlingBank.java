package org.jarling.v2;

import org.jarling.v2.api.AccountHolderResource;
import org.jarling.v2.api.AddressesResource;
import org.jarling.v2.api.ApiUserIdentityResource;
import org.jarling.v2.api.BusinessesResource;
import org.jarling.v2.api.IndividualsResource;

public interface StarlingBank extends AccountHolderResource, AddressesResource, ApiUserIdentityResource, BusinessesResource, IndividualsResource {
    AccountHolderResource accountHolder();
    AddressesResource addresses();
    ApiUserIdentityResource identity();
    BusinessesResource businesses();
    IndividualsResource individuals();
}
