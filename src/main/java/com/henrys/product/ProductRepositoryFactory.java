package com.henrys.product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepositoryFactory {
    private final Map<String, Product> products = new HashMap<>();

    public ProductRepository create() {
        add(new Product("soup", "tin", 65));
        add(new Product("bread", "loaf", 80));
        add(new Product("milk", "bottle", 130));
        add(new Product("apples", "single", 10));
        return new ProductRepository(products);
    }

    private void add(Product product) {
        products.put(product.getName(), product);
    }
}
