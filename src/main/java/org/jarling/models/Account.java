package org.jarling.models;

import java.util.Date;

/**
 *
 * Model class representing an account returned by the Account API.
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class Account {

    private String bic;
    private Date createdAt;
    private String currency;
    private String iban;
    private String id;
    private String name;
    private String number;
    private String sortCode;

    public String getBic() {
        return bic;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getCurrency() {
        return currency;
    }

    public String getIban() {
        return iban;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getSortCode() {
        return sortCode;
    }

    @Override
    public String toString() {
        return "Account{" +
                "bic='" + bic + '\'' +
                ", createdAt=" + createdAt +
                ", currency='" + currency + '\'' +
                ", iban='" + iban + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", sortCode='" + sortCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (bic != null ? !bic.equals(account.bic) : account.bic != null) return false;
        if (createdAt != null ? !createdAt.equals(account.createdAt) : account.createdAt != null) return false;
        if (currency != null ? !currency.equals(account.currency) : account.currency != null) return false;
        if (iban != null ? !iban.equals(account.iban) : account.iban != null) return false;
        if (id != null ? !id.equals(account.id) : account.id != null) return false;
        if (name != null ? !name.equals(account.name) : account.name != null) return false;
        if (number != null ? !number.equals(account.number) : account.number != null) return false;
        return sortCode != null ? sortCode.equals(account.sortCode) : account.sortCode == null;

    }

    @Override
    public int hashCode() {
        int result = bic != null ? bic.hashCode() : 0;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (iban != null ? iban.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (sortCode != null ? sortCode.hashCode() : 0);
        return result;
    }
}
