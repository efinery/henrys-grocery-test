package com.henrys.promotion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.now;

public class PromotionRepositoryFactory {

    public PromotionRepository create() {
        List<Promotion> promotions = new ArrayList<>();

        LocalDate yesterday = now().minusDays(1);
        Promotion halfPriceBreadForTwoSoups = new Promotion(
                yesterday,
                yesterday.plusWeeks(1),
                new HalfPriceBreadWithTwoSoupsPromotionRule());

        Promotion applesTenPercentOff = new Promotion(
                now().plusDays(3),
                now().plusMonths(2).withDayOfMonth(1).minusDays(1),
                null);

        promotions.add(halfPriceBreadForTwoSoups);
        promotions.add(applesTenPercentOff);
        return new PromotionRepository(promotions);
    }
}
