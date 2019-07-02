package org.jarling.v2.models.payments;

import com.neovisionaries.i18n.CountryCode;
import lombok.Data;
import lombok.ToString;
import org.jarling.v2.models.payees.BankIdentifierType;
import org.jarling.v2.models.payees.PayeeType;

@Data
@ToString(onlyExplicitlyIncluded = true )
public class PaymentRecipient {
    /**
     * Payee name
     *
     * minLength: 1
     * maxLength: 255
     * Not null
     */
    String payeeName;

    /**
     * Payee type
     * Not null
     */
    PayeeType payeeType;

    /**
     * The country code for the account
     * Not null
     */
    CountryCode countryCode;

    /**
     * Account identifier, e.g. account number
     *
     * minLength: 0
     * maxLength: 34
     * Not null
     */
    String accountIdentifier;

    /**
     * Bank identifier, e.g. sort code
     *
     * minLength: 0
     * maxLength: 34
     * Not null
     */
    String bankIdentifier;

    /**
     * Bank identifier type
     * Not null
     */
    BankIdentifierType bankIdentifierType;
}
