package com.henrys.product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepositoryFactory {

    public ProductRepository create() {
        Map<String, Product> products = new HashMap<>();

        Product soup = new Product("soup", "tin", 65);
        products.put(soup.getName(), soup);

        Product bread = new Product("bread", "loaf", 80);
        products.put(bread.getName(), bread);

        Product milk = new Product("milk", "bottle", 130);
        products.put(milk.getName(), milk);

        Product apples = new Product("apples", "single", 10);
        products.put(apples.getName(), apples);

        return new ProductRepository(products);
    }
}
