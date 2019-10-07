package org.jarling.v2.individuals;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;
import org.jarling.v2.models.individuals.Individual;

import java.time.LocalDate;

import static org.jarling.v2.JarlingAssertions.assertThat;

public class IndividualAssert extends AbstractAssert<IndividualAssert, Individual> {
    public IndividualAssert(Individual actual) {
        super(actual, IndividualAssert.class);
    }

    public IndividualAssert isValid() {
        isNotNull();

        assertThat(actual.getEmail()).isEmail();
        assertThat(actual.getFirstName()).isNotEmpty();
        assertThat(actual.getLastName()).isNotEmpty();
        assertThat(actual.getDateOfBirth()).isBefore(LocalDate.now());

        return this;
    }

    public IndividualAssert hasEmail(String email) {
        // check that actual Individual we want to make assertions on is not null.
        isNotNull();

        // overrides the default error message with a more explicit one
        String assertjErrorMessage = "\nExpecting email of:\n  <%s>\nto be:\n  <%s>\nbut was:\n  <%s>";

        // null safe check
        String actualEmail = actual.getEmail();
        if (!Objects.areEqual(actualEmail, email)) {
            failWithMessage(assertjErrorMessage, actual.getFirstName() + " " + actual.getLastName(), email, actualEmail);
        }

        // return the current assertion for method chaining
        return this;
    }
}
