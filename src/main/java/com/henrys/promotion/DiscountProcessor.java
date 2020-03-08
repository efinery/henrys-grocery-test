package com.henrys.promotion;

import com.henrys.basket.Basket;

import java.util.List;

public class DiscountProcessor {
    private final PromotionRepository promotionRepository;

    public DiscountProcessor(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    public int calculateDiscounts(Basket basket) {
        DiscountCollector discountCollector = new DiscountCollector();

        List<PromotionRule> promotionRules = promotionRepository.find(basket.getCreated());
        for (PromotionRule promotionRule : promotionRules) {
            promotionRule.check(basket, discountCollector);
        }

        return discountCollector.totalDiscount(basket);
    }
}
