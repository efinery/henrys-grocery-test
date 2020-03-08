package com.henrys.promotion;

import com.henrys.basket.Basket;
import com.henrys.product.Product;
import com.henrys.product.ProductRepository;

public class TenPercentOffApplesPromotionRule implements PromotionRule {
    private static final String APPLES = "apples";
    private final ProductRepository productRepository;

    TenPercentOffApplesPromotionRule(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void check(Basket basket, DiscountCollector discountCollector) {
        int totalApples = basket.query().quantity(APPLES);
        if (totalApples > 0) {
            Product apples = productRepository.findByName(APPLES);
            discountCollector.add(new PercentOffDiscount(apples, 10));
        }
    }
}
