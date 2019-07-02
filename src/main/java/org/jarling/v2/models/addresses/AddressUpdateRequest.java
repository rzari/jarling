package org.jarling.v2.models.addresses;

import com.neovisionaries.i18n.CountryCode;
import lombok.*;

import java.time.LocalDate;

/**
 * Address update request
 */
@Data
@ToString(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class AddressUpdateRequest {
    /**
     * First line, 0-255 characters
     */
    private @NonNull String line1;

    /**
     * Second line, 0-255 characters
     */
    private String line2;

    /**
     * Third line, 0-255 characters
     */
    private String line3;

    /**
     * Post town, 0-255 characters
     */
    private @NonNull String postTown;

    /**
     * Post code, 0-20 characters
     */
    private @NonNull String postCode;

    private @NonNull CountryCode countryCode;

    /**
     * The udprn of the property, 0-255 characters
     */
    private String udprn;

    /**
     * The umprn of the property, 0-255 characters
     */
    private String umprn;

    /**
     * Date the account holder’s residency at this address started
     */
    private @NonNull LocalDate from;
}
