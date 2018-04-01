package org.jarling.models.contacts;

/**
 *
 * Model class representing a contacts account returned by the Contact API.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class ContactAccount {
    private final String accountNumber;
    private String id;
    private final String name;
    private final String sortCode;
    private final ContactAccountType type;

    public ContactAccount(String name, String sortCode, String accountNumber, ContactAccountType contactAccountType){
        this.name = name;
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;
        this.type = contactAccountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSortCode() {
        return sortCode;
    }

    public ContactAccountType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ContactAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sortCode='" + sortCode + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactAccount that = (ContactAccount) o;

        if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (sortCode != null ? !sortCode.equals(that.sortCode) : that.sortCode != null) return false;
        return type == that.type;

    }

    @Override
    public int hashCode() {
        int result = accountNumber != null ? accountNumber.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sortCode != null ? sortCode.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
