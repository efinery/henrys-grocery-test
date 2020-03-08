package com.henrys.promotion;

import java.time.LocalDate;

public class Promotion {
    private final LocalDate validFrom;
    private final LocalDate validTo;

    public Promotion(LocalDate validFrom, LocalDate validTo) {
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public boolean isValidFor(LocalDate current) {
        return !current.isBefore(validFrom) && !current.isAfter(validTo);
    }
}
