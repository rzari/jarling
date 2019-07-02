package org.jarling.v2.models.payments;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class StandingOrderRecurrence {
    LocalDate startDate;
    StandingOrderFrequency frequency;
    Integer interval;
    Integer count;
    LocalDate untilDate;
}
