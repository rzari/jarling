package org.jarling;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertTrue;

public class TestUtils {
    public static final DateFormat transactionDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    //Regex for matching dynamic data
    public static final String regexUUID          = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}";
    public static final String regexSortCode      = "[0-9]{6}";
    public static final String regexAccountNumber = "[0-9]{8}";
    public static final String regexBIC           = "([a-zA-Z]{4}[a-zA-Z]{2}[a-zA-Z0-9]{2}([a-zA-Z0-9]{3})?)";
    public static final String regexIBAN          = "[a-zA-Z]{2}[0-9]{2}[a-zA-Z0-9]{4}[0-9]{7}([a-zA-Z0-9]?){0,16}";
    public static final String regexPostCode      = "([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9]?[A-Za-z]))))\\s?[0-9][A-Za-z]{2})";
    public static final String regexEmail         = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])";

    public static void assertValidSortCode(String sortCode) {
        assertTrue(sortCode.matches(regexSortCode));
    }

    public static void assertValidAccountNumber(String accountNumber) {
        assertTrue(accountNumber.matches(regexAccountNumber));
    }

    public static void assertValidBic(String bic) {
        assertTrue(bic.matches(regexBIC));
    }

    public static void assertValidIban(String iban) {
        assertTrue(iban.matches(regexIBAN));
    }

    public static void assertValidPostCode(String postCode) {
        assertTrue(postCode.matches(regexPostCode));
    }

    public static void assertValidEmail(String email) {
        assertTrue(email.matches(regexEmail));
    }
}
