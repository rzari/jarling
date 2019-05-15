package org.jarling.v2;

import org.jarling.v2.api.AccountHolderResource;
import org.jarling.v2.api.ApiUserIdentityResource;

public interface StarlingBank extends AccountHolderResource, ApiUserIdentityResource {
    AccountHolderResource accountHolder();
    ApiUserIdentityResource identity();
}
