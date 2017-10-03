package org.jarling.models;

/**
 *
 * Model class representing a customer returned by the Customer API.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class Customer {
    private String customerUid;
    private String dateOfBirth;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;

    public String getCustomerUid() {
        return customerUid;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerUid='" + customerUid + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (customerUid != null ? !customerUid.equals(customer.customerUid) : customer.customerUid != null)
            return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(customer.dateOfBirth) : customer.dateOfBirth != null)
            return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        if (firstName != null ? !firstName.equals(customer.firstName) : customer.firstName != null) return false;
        if (lastName != null ? !lastName.equals(customer.lastName) : customer.lastName != null) return false;
        return phone != null ? phone.equals(customer.phone) : customer.phone == null;

    }

    @Override
    public int hashCode() {
        int result = customerUid != null ? customerUid.hashCode() : 0;
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
