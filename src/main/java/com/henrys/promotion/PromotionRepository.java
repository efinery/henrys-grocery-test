package com.henrys.promotion;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class PromotionRepository {
    private final List<Promotion> promotions;

    PromotionRepository(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    List<PromotionRule> find(LocalDate date) {
        return promotions.stream()
                .filter(p -> p.isValidFor(date))
                .map(Promotion::getRule)
                .collect(toList());
    }
}
