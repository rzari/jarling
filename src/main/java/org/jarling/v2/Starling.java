package org.jarling.v2;

import org.jarling.StarlingBankApiVersion;
import org.jarling.StarlingBankEnvironment;
import org.jarling.StarlingBase;
import org.jarling.exceptions.StarlingBankRequestException;
import org.jarling.v2.api.ApiUserIdentityResource;
import org.jarling.v2.models.Identity;
import org.jarling.v2.models.Individual;

/**
 * API class responsible for creating services to access Starling Bank resources
 */
public final class Starling extends StarlingBase implements StarlingBank {

    public Starling(StarlingBankEnvironment environment, String accessToken) {
        super(StarlingBankApiVersion.V2, environment, accessToken);
    }

    @Override
    public Individual getAuthorisingIndividual() throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/identity/individual").asString(), Individual.class);
    }

    @Override
    public Identity getTokenIdentity() throws StarlingBankRequestException {
        return gson.fromJson(apiService.get("/identity/token").asString(), Identity.class);
    }

    @Override
    public ApiUserIdentityResource identity() {
        return this;
    }
}
