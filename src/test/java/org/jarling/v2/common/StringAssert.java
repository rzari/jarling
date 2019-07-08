package org.jarling.v2.common;

import org.assertj.core.api.AbstractStringAssert;
import org.jarling.TestUtils;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class StringAssert extends AbstractStringAssert<StringAssert> {
    public StringAssert(String actual) {
        super(actual, StringAssert.class);
    }

    public StringAssert isEmail() {
        isNotNull();

        if (!actual.matches(TestUtils.regexEmail)) {
            failWithMessage("Expected email but got <%s>", actual);
        }

        return this;
    }

    public StringAssert isSortCode() {
        isNotNull();

        if (!actual.matches(TestUtils.regexSortCode)) {
            failWithMessage("Expected sort code but got <%s>", actual);
        }

        return this;
    }

    public StringAssert isAccountNumber() {
        isNotNull();

        if (!actual.matches(TestUtils.regexAccountNumber)) {
            failWithMessage("Expected account number but got <%s>", actual);
        }

        return this;
    }

    public StringAssert isBic() {
        isNotNull();

        if (!actual.matches(TestUtils.regexBIC)) {
            failWithMessage("Expected BIC but got <%s>", actual);
        }

        return this;
    }

    public StringAssert isIban() {
        isNotNull();

        if (!actual.matches(TestUtils.regexIBAN)) {
            failWithMessage("Expected IBAN but got <%s>", actual);
        }

        return this;
    }

    public StringAssert isValidPaymentReference() {
        isNotNull();
        assertThat(actual).satisfiesAnyOf(
            // Required by documentation:
            string -> assertThat(string).matches("[a-zA-Z0-9-/?:().,+#=!%&*<>;{@ \"']{1,18}"),
            // Seen in sandbox data:
            string -> assertThat(string).isEqualTo("TEST_RECURRING_PAYMENT")
        );

        return this;
    }

    public StringAssert isMimeType() {
        isNotNull();
        assertThat(actual).matches("^(?=[-a-z]{1,127}/[-.a-z0-9]{1,127}$)[a-z]+(-[a-z]+)*/[a-z0-9]+([-.][a-z0-9]+)*$");
        return this;
    }
}
