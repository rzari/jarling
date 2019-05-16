package org.jarling.v2.models.addresses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

/**
 * Address update request
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class AddressUpdateRequest {
    @NonNull private String line1;
    private String line2;
    private String line3;
    @NonNull private String postTown;
    @NonNull private String postCode;
    @NonNull private String countryCode;
    private String udprn;
    private String umprn;
    @NonNull private LocalDate from;
}
