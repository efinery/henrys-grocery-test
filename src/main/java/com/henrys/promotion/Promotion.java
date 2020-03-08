package com.henrys.promotion;

import java.time.LocalDate;

public class Promotion {
    private final LocalDate validFrom;
    private final LocalDate validTo;
    private final PromotionRule rule;

    Promotion(LocalDate validFrom, LocalDate validTo, PromotionRule rule) {
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.rule = rule;
    }

    boolean isValidFor(LocalDate current) {
        return !current.isBefore(validFrom) && !current.isAfter(validTo);
    }

    public PromotionRule getRule() {
        return rule;
    }
}
