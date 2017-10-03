package org.jarling.models;

/**
 *
 * Model class representing a merchant returned by the Starling Bank Merchant API.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class Merchant {
    private String merchantUid;
    private String name;
    private String phoneNumber;
    private String twitterUsername;
    private String website;

    public String getMerchantUid() {
        return merchantUid;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getTwitterUsername() {
        return twitterUsername;
    }

    public String getWebsite() {
        return website;
    }

    @Override
    public String toString() {
        return "Merchant{" +
                "merchantUid='" + merchantUid + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", twitterUsername='" + twitterUsername + '\'' +
                ", website='" + website + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Merchant merchant = (Merchant) o;

        if (merchantUid != null ? !merchantUid.equals(merchant.merchantUid) : merchant.merchantUid != null)
            return false;
        if (name != null ? !name.equals(merchant.name) : merchant.name != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(merchant.phoneNumber) : merchant.phoneNumber != null)
            return false;
        if (twitterUsername != null ? !twitterUsername.equals(merchant.twitterUsername) : merchant.twitterUsername != null)
            return false;
        return website != null ? website.equals(merchant.website) : merchant.website == null;

    }

    @Override
    public int hashCode() {
        int result = merchantUid != null ? merchantUid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (twitterUsername != null ? twitterUsername.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        return result;
    }
}
