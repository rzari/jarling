package org.jarling.models;

import java.util.Arrays;
import java.util.Date;

/**
 *
 * Model class representing 'me' returned by the Who Am I API.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class WhoAmI {
    private String customerUid;
    private Date expiresAt;
    private Integer expiresInSeconds;
    private String[] scopes;
    private Boolean authenticated;

    public String getCustomerUid() {
        return customerUid;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public Integer getExpiresInSeconds() {
        return expiresInSeconds;
    }

    public String[] getScopes() {
        return scopes;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    @Override
    public String toString() {
        return "WhoAmI{" +
                "customerUid='" + customerUid + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WhoAmI whoAmI = (WhoAmI) o;

        if (customerUid != null ? !customerUid.equals(whoAmI.customerUid) : whoAmI.customerUid != null) return false;
        if (expiresAt != null ? !expiresAt.equals(whoAmI.expiresAt) : whoAmI.expiresAt != null) return false;
        if (expiresInSeconds != null ? !expiresInSeconds.equals(whoAmI.expiresInSeconds) : whoAmI.expiresInSeconds != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(scopes, whoAmI.scopes)) return false;
        return authenticated != null ? authenticated.equals(whoAmI.authenticated) : whoAmI.authenticated == null;

    }

    @Override
    public int hashCode() {
        int result = customerUid != null ? customerUid.hashCode() : 0;
        result = 31 * result + (expiresAt != null ? expiresAt.hashCode() : 0);
        result = 31 * result + (expiresInSeconds != null ? expiresInSeconds.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(scopes);
        result = 31 * result + (authenticated != null ? authenticated.hashCode() : 0);
        return result;
    }
}
