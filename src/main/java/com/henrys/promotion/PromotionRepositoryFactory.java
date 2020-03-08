package com.henrys.promotion;

import com.henrys.product.ProductRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.henrys.promotion.DateRange.newDateRange;
import static java.time.LocalDate.now;

public class PromotionRepositoryFactory {
    private final ProductRepository productRepository;

    public PromotionRepositoryFactory(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public PromotionRepository create() {
        List<Promotion> promotions = new ArrayList<>();
        promotions.add(halfPriceBreadForTwoSoups());
        promotions.add(applesTenPercentOff());
        return new PromotionRepository(promotions);
    }

    private Promotion halfPriceBreadForTwoSoups() {
        LocalDate yesterday = now().minusDays(1);
        return new Promotion(
                newDateRange()
                        .starting(yesterday)
                        .ending(yesterday.plusWeeks(1))
                        .build(),
                new HalfPriceBreadWithTwoSoupsPromotionRule(productRepository));
    }

    private Promotion applesTenPercentOff() {
        LocalDate threeDaysHence = now().plusDays(3);
        LocalDate endOfFollowingMonth = now().plusMonths(2).withDayOfMonth(1).minusDays(1);
        return new Promotion(
                newDateRange()
                        .starting(threeDaysHence)
                        .ending(endOfFollowingMonth)
                        .build(),
                new TenPercentOffApplesPromotionRule(productRepository));
    }
}
