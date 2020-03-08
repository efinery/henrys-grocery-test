package com.henrys;

import com.henrys.product.Product;
import com.henrys.product.ProductRepository;
import com.henrys.promotion.PromotionRepository;

import java.util.List;

public class BasketTotaller {
    private final ProductRepository productRepository;
    private final PromotionRepository promotionRepository;

    public BasketTotaller(ProductRepository productRepository, PromotionRepository promotionRepository) {
        this.productRepository = productRepository;
        this.promotionRepository = promotionRepository;
    }

    public int total(List<String> productNames) {
        return calulateTotal(productNames);
    }

    private int calulateTotal(List<String> productNames) {
        int total = 0;

        for (String productName : productNames) {
            Product product = productRepository.findByName(productName);
            total += product.getPriceInPence();
        }

        return total;
    }
}
