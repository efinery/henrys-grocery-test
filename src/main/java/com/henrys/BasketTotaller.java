package com.henrys;

import com.henrys.product.Product;
import com.henrys.product.ProductRepository;

import java.util.List;

public class BasketTotaller {
    private final ProductRepository productRepository;

    public BasketTotaller(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
