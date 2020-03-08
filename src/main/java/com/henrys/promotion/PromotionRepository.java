package com.henrys.promotion;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PromotionRepository {
    private final List<Promotion> promotions;

    PromotionRepository(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public List<Promotion> find(LocalDate date) {
        return promotions.stream()
                .filter(p -> p.isValidFor(date))
                .collect(Collectors.toList());
    }
}
