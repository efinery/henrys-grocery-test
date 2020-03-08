package com.henrys.product;

import java.util.Map;

public class ProductRepository {
    private final Map<String, Product> products;

    ProductRepository(Map<String, Product> products) {
        this.products = products;
    }

    public Product findByName(String productName) {
        Product product = products.get(productName);
        if (product == null) {
            throw new NoSuchProductException(productName);
        }
        return product;
    }
}
