package org.jarling.v2.models.payments;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString(onlyExplicitlyIncluded = true)
public class StandingOrderRecurrence {
    /**
     * Date of the first payment
     */
    private @NonNull LocalDate startDate;

    private @NonNull StandingOrderFrequency frequency;

    /**
     * Interval of specified frequency on which payments should be made
     * Min: 1; Max: 20
     */
    private Integer interval;

    /**
     * Number of payments that should be made before standing order is stopped
     * Min: 1; Max: 100
     */
    private Integer count;

    /**
     * Date on which to stop the standing order
     */
    private LocalDate untilDate;
}
