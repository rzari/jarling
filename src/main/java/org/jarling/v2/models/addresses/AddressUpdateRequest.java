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
    public AddressUpdateRequest(String line1, String postTown, String postCode, String countryCode, LocalDate from) {
        this(line1, null, null, postTown, postCode, countryCode, null, null, from);
    }

    public AddressUpdateRequest(String line1, String line2, String line3, String postTown, String postCode, String countryCode, String udprn, String umprn, LocalDate from) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.postTown = postTown;
        this.postCode = postCode;
        this.countryCode = CountryCode.getByCode(countryCode, false);
        this.udprn = udprn;
        this.umprn = umprn;
        this.from = from;
    }

    @NonNull private String line1;
    private String line2;
    private String line3;
    @NonNull private String postTown;
    @NonNull private String postCode;
    @NonNull private CountryCode countryCode;
    private String udprn;
    private String umprn;
    @NonNull private LocalDate from;
}
