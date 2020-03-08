package com.henrys.promotion;

import org.junit.Test;

import java.time.LocalDate;

import static com.henrys.promotion.DateRange.newDateRange;

public class DateRangeTest {
    private final LocalDate today = LocalDate.now();
    private final LocalDate yesterday = today.minusDays(1);

    @Test(expected = IllegalStateException.class)
    public void start_date_should_be_mandatory() {
        newDateRange()
                .starting(null)
                .ending(today)
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void end_date_should_be_mandatory() {
        newDateRange()
                .starting(today)
                .ending(null)
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void should_not_allow_start_after_end() {
        newDateRange()
                .starting(today)
                .ending(yesterday)
                .build();
    }

    @Test
    public void should_allow_start_and_end_on_same_day() {
        newDateRange()
                .starting(today)
                .ending(today)
                .build();
    }

}