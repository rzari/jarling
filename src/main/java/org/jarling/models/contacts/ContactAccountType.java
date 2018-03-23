package org.jarling.models.contacts;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public enum ContactAccountType {

    UK_ACCOUNT_AND_SORT_CODE("UK_ACCOUNT_AND_SORT_CODE");

    private final String value;

    ContactAccountType(String value){ this.value = value; }

    public String getValue() {
        return this.value;
    }

}
