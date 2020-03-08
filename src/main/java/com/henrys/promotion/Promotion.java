package com.henrys.promotion;

import java.time.LocalDate;

class Promotion {
    private final DateRange dateRange;
    private final PromotionRule rule;

    Promotion(DateRange dateRange, PromotionRule rule) {
        this.dateRange = dateRange;
        this.rule = rule;
    }

    boolean isValidFor(LocalDate current) {
        return dateRange.isValidFor(current);
    }

    PromotionRule getRule() {
        return rule;
    }
}
