package org.jarling.models;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public enum DayOfWeek {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    private final Integer dayNumber;

    DayOfWeek(Integer dayNumber){ this.dayNumber = dayNumber; }

    public Integer getDayNumber() {
        return this.dayNumber;
    }
}
