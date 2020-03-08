package com.henrys.promotion;

import com.henrys.basket.Basket;
import com.henrys.product.Product;
import com.henrys.product.ProductRepository;

public class HalfPriceBreadWithTwoSoupsPromotionRule implements PromotionRule {
    private final ProductRepository productRepository;

    HalfPriceBreadWithTwoSoupsPromotionRule(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void check(Basket basket, DiscountCollector discountCollector) {
        int tinsOfSoup = basket.query().quantity("soup");
        if (tinsOfSoup > 1) {
            int loavesToDiscount = tinsOfSoup / 2;
            Product bread = productRepository.findByName("bread");
            discountCollector.add(new HalfPriceDiscount(bread, loavesToDiscount));
        }
    }
}
