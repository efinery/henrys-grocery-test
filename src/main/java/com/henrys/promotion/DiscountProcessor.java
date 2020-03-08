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

        List<Promotion> promotions = promotionRepository.find(basket.getCreated());
        for (Promotion promotion : promotions) {
            PromotionRule promotionRule = promotion.getRule();
            promotionRule.check(basket, discountCollector);
        }

        return discountCollector.totalDiscount(basket);
    }
}
