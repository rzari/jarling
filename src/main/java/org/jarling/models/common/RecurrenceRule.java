package org.jarling.models.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nav Roudsari (nav@rzari.co.uk)
 *
 */
public class RecurrenceRule {
    private final Date startDate;
    private final Frequency frequency;
    private final Integer interval;
    private final Integer count;
    private final Date untilDate;
    private final DayOfWeek weekStart;
    private final List<DayOfWeek> days;
    private final Integer monthDay;
    private final Integer monthWeek;

    public RecurrenceRule(Date startDate, Frequency frequency, Integer interval, Integer count, Date untilDate, DayOfWeek weekStart, List<DayOfWeek> days, Integer monthDay, Integer monthWeek) {
        this.startDate = startDate;
        this.frequency = frequency;
        this.interval = interval;
        this.count = count;
        this.untilDate = untilDate;
        this.weekStart = weekStart;
        this.days = (days == null ? new ArrayList<>() : days);
        this.monthDay = monthDay;
        this.monthWeek = monthWeek;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public Integer getInterval() {
        return interval;
    }

    public Integer getCount() {
        return count;
    }

    public Date getUntilDate() {
        return untilDate;
    }

    public DayOfWeek getWeekStart() {
        return weekStart;
    }

    public List<DayOfWeek> getDays() {
        return days;
    }

    public Integer getMonthDay() {
        return monthDay;
    }

    public Integer getMonthWeek() {
        return monthWeek;
    }

    public void add(DayOfWeek dayOfWeek){
        if (!this.days.contains(dayOfWeek)){
            this.days.add(dayOfWeek);
        }
    }

    @Override
    public String toString() {
        return "RecurrenceRule{" +
                "startDate=" + startDate +
                ", frequency=" + frequency +
                ", interval=" + interval +
                ", count=" + count +
                ", untilDate=" + untilDate +
                ", weekStart=" + weekStart +
                ", days=" + days +
                ", monthDay=" + monthDay +
                ", monthWeek=" + monthWeek +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecurrenceRule that = (RecurrenceRule) o;

        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (frequency != that.frequency) return false;
        if (interval != null ? !interval.equals(that.interval) : that.interval != null) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (untilDate != null ? !untilDate.equals(that.untilDate) : that.untilDate != null) return false;
        if (weekStart != that.weekStart) return false;
        if (days != null ? !days.equals(that.days) : that.days != null) return false;
        if (monthDay != null ? !monthDay.equals(that.monthDay) : that.monthDay != null) return false;
        return monthWeek != null ? monthWeek.equals(that.monthWeek) : that.monthWeek == null;
    }

    @Override
    public int hashCode() {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (frequency != null ? frequency.hashCode() : 0);
        result = 31 * result + (interval != null ? interval.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (untilDate != null ? untilDate.hashCode() : 0);
        result = 31 * result + (weekStart != null ? weekStart.hashCode() : 0);
        result = 31 * result + (days != null ? days.hashCode() : 0);
        result = 31 * result + (monthDay != null ? monthDay.hashCode() : 0);
        result = 31 * result + (monthWeek != null ? monthWeek.hashCode() : 0);
        return result;
    }
}
