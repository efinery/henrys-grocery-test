package com.henrys.promotion;

import com.henrys.basket.Basket;
import com.henrys.product.Product;

public class PercentOffDiscount implements Discount {
    private final Product product;
    private final int percentageOff;

    PercentOffDiscount(Product product, int percentageOff) {
        this.product = product;
        this.percentageOff = percentageOff;
    }

    @Override
    public int calculateDiscount(Basket basket) {
        int quantity = basket.query().quantity(product.getName());
        int totalPrice = product.getPriceInPence() * quantity;
        return totalPrice * percentageOff / 100;
    }
}
