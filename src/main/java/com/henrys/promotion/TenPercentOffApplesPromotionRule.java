package com.henrys.promotion;

import com.henrys.basket.Basket;
import com.henrys.product.Product;
import com.henrys.product.ProductRepository;

public class TenPercentOffApplesPromotionRule implements PromotionRule {
    private final ProductRepository productRepository;

    TenPercentOffApplesPromotionRule(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void check(Basket basket, DiscountCollector discountCollector) {
        int totalApples = basket.query().quantity("apples");
        if (totalApples > 0) {
            Product apples = productRepository.findByName("apples");
            discountCollector.add(new PercentOffDiscount(apples, 10));
        }
    }
}
