package org.jarling.models.merchants;

/**
 *
 * Model class representing a merchants location returned by the Starling Bank Merchant API.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class MerchantLocation {

    private String  merchantUid;
    private String  merchantName;
    private String  phoneNumber;
    private String  merchantLocationUid;
    private String  locationName;
    private String  address;
    private String  googlePlaceId;
    private Integer mastercardMerchantCategoryCode;

    public String getMerchantUid() {
        return merchantUid;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMerchantLocationUid() {
        return merchantLocationUid;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getAddress() {
        return address;
    }

    public String getGooglePlaceId() {
        return googlePlaceId;
    }

    public Integer getMastercardMerchantCategoryCode() {
        return mastercardMerchantCategoryCode;
    }

    @Override
    public String toString() {
        return "MerchantLocation{" +
                "merchantUid='" + merchantUid + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", merchantLocationUid='" + merchantLocationUid + '\'' +
                ", locationName='" + locationName + '\'' +
                ", address='" + address + '\'' +
                ", googlePlaceId='" + googlePlaceId + '\'' +
                ", mastercardMerchantCategoryCode=" + mastercardMerchantCategoryCode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MerchantLocation that = (MerchantLocation) o;

        if (merchantUid != null ? !merchantUid.equals(that.merchantUid) : that.merchantUid != null) return false;
        if (merchantName != null ? !merchantName.equals(that.merchantName) : that.merchantName != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (merchantLocationUid != null ? !merchantLocationUid.equals(that.merchantLocationUid) : that.merchantLocationUid != null)
            return false;
        if (locationName != null ? !locationName.equals(that.locationName) : that.locationName != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (googlePlaceId != null ? !googlePlaceId.equals(that.googlePlaceId) : that.googlePlaceId != null)
            return false;
        return mastercardMerchantCategoryCode != null ? mastercardMerchantCategoryCode.equals(that.mastercardMerchantCategoryCode) : that.mastercardMerchantCategoryCode == null;

    }

    @Override
    public int hashCode() {
        int result = merchantUid != null ? merchantUid.hashCode() : 0;
        result = 31 * result + (merchantName != null ? merchantName.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (merchantLocationUid != null ? merchantLocationUid.hashCode() : 0);
        result = 31 * result + (locationName != null ? locationName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (googlePlaceId != null ? googlePlaceId.hashCode() : 0);
        result = 31 * result + (mastercardMerchantCategoryCode != null ? mastercardMerchantCategoryCode.hashCode() : 0);
        return result;
    }
}
