package com.henrys.basket;

import com.henrys.product.Product;

public class BasketQuery {
    private final Basket basket;

    public BasketQuery(Basket basket) {
        this.basket = basket;
    }

    public int total() {
        int total = 0;

        for (Product product : basket.getProducts()) {
            total += product.getPriceInPence();
        }

        return total;
    }
}
