package org.jarling.v2;

import org.jarling.v2.api.*;

public interface StarlingBank extends AccountHolderResource, AccountsResource, AddressesResource, ApiUserIdentityResource, BusinessesResource, TransactionFeedResource, IndividualsResource, JointAccountsResource, KycResource {
    AccountHolderResource accountHolder();
    AccountsResource accounts();
    AddressesResource addresses();
    ApiUserIdentityResource identity();
    BusinessesResource businesses();
    TransactionFeedResource transactionFeed();
    IndividualsResource individuals();
    JointAccountsResource jointAccounts();
    KycResource kyc();
}
