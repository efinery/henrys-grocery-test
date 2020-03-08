package com.henrys.basket;

import com.henrys.product.Product;

public class BasketQuery {
    private final Basket basket;

    BasketQuery(Basket basket) {
        this.basket = basket;
    }

    public int total() {
        int total = 0;

        for (Product product : basket.getProducts()) {
            total += product.getPriceInPence();
        }

        return total;
    }

    public int quantity(String productName) {
        return (int) basket.getProducts().stream()
                .filter(p -> p.getName().equals(productName))
                .count();
    }
}
