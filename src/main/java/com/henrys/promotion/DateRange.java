package com.henrys.promotion;

import java.time.LocalDate;

class DateRange {
    private final LocalDate start;
    private final LocalDate end;

    private DateRange(Builder builder) {
        this.start = builder.start;
        this.end = builder.end;
    }

    static Builder newDateRange() {
        return new Builder();
    }

    boolean isValidFor(LocalDate date) {
        return !date.isBefore(start) && !date.isAfter(end);
    }

    static class Builder {
        private LocalDate start;
        private LocalDate end;

        DateRange build() {
            if (start == null) {
                throw new IllegalStateException("Start date is required");
            }
            if (end == null) {
                throw new IllegalStateException("End date is required");
            }
            if (end.isBefore(start)) {
                throw new IllegalStateException("End date must be after start date");
            }
            return new DateRange(this);
        }

        Builder starting(LocalDate start) {
            this.start = start;
            return this;
        }

        Builder ending(LocalDate end) {
            this.end = end;
            return this;
        }
    }
}
