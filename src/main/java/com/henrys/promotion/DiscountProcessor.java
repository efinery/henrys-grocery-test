package com.henrys.promotion;

import com.henrys.basket.Basket;

import java.time.LocalDate;
import java.util.List;

public class DiscountProcessor {
    private final PromotionRepository promotionRepository;

    public DiscountProcessor(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public int calculateDiscounts(Basket basket, LocalDate date) {
        DiscountCollector discountCollector = new DiscountCollector();

        List<Promotion> promotions = promotionRepository.find(date);
        for (Promotion promotion : promotions) {
            PromotionRule promotionRule = promotion.getRule();
            promotionRule.check(basket, discountCollector);
        }

        return discountCollector.totalDiscount(basket);
    }
}
