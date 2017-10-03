package org.jarling.models;

/**
 *
 * Model class representing a address returned by the Address API.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class Address {

    private String city;
    private String country;
    private String postcode;
    private String streetAddress;

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", postcode='" + postcode + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        if (postcode != null ? !postcode.equals(address.postcode) : address.postcode != null) return false;
        return streetAddress != null ? streetAddress.equals(address.streetAddress) : address.streetAddress == null;

    }

    @Override
    public int hashCode() {
        int result = city != null ? city.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (streetAddress != null ? streetAddress.hashCode() : 0);
        return result;
    }
}
