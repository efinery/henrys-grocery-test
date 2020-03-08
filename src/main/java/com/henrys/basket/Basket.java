package com.henrys.basket;

import com.henrys.product.Product;

import java.util.List;

public class Basket {
    private final List<Product> products;

    Basket(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
