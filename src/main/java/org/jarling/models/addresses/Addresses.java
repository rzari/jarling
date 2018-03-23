package org.jarling.models.addresses;

import com.google.gson.annotations.JsonAdapter;
import org.jarling.models.gson.AddressesDeserializer;

/**
 *
 * Model class representing a contacts current and previous addresses returned by the Address API.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
@JsonAdapter(AddressesDeserializer.class)
public class Addresses {

    private Address current;
    private Address previous;

    public Address getCurrent() {
        return current;
    }

    public Address getPrevious() {
        return previous;
    }

    @Override
    public String toString() {
        return "Addresses{" +
                "current{" +
                "city='" + current.getCity() + '\'' +
                ", country='" + current.getCountry() + '\'' +
                ", postcode='" + current.getPostcode() + '\'' +
                ", streetAddress='" + current.getStreetAddress() + '\'' +
                '}' +
                "previous{" +
                "city='" + current.getCity() + '\'' +
                ", country='" + current.getCountry() + '\'' +
                ", postcode='" + current.getPostcode() + '\'' +
                ", streetAddress='" + current.getStreetAddress() + '\'' +
                "}}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Addresses addresses = (Addresses) o;

        if (current != null ? !current.equals(addresses.current) : addresses.current != null) return false;
        return previous != null ? previous.equals(addresses.previous) : addresses.previous == null;

    }

    @Override
    public int hashCode() {
        int result = current != null ? current.hashCode() : 0;
        result = 31 * result + (previous != null ? previous.hashCode() : 0);
        return result;
    }
}
