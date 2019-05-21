package org.jarling.v2;

import org.jarling.v2.api.*;

public interface StarlingBank extends AccountHolderResource, AddressesResource, ApiUserIdentityResource, BusinessesResource, IndividualsResource, JointAccountsResource {
    AccountHolderResource accountHolder();
    AddressesResource addresses();
    ApiUserIdentityResource identity();
    BusinessesResource businesses();
    IndividualsResource individuals();
    JointAccountsResource jointAccounts();
}
