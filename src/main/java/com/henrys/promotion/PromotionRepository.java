package com.henrys.promotion;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PromotionRepository {
    private final List<Promotion> promotions;

    public PromotionRepository(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public List<Promotion> find(LocalDate current) {
        return promotions.stream()
                .filter(p -> p.isValidFor(current))
                .collect(Collectors.toList());
    }
}
