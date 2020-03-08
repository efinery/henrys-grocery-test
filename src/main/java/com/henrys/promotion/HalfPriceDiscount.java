package com.henrys.promotion;

import com.henrys.basket.Basket;
import com.henrys.product.Product;

import static java.lang.Math.min;

public class HalfPriceDiscount implements Discount {
    private final Product product;
    private final int amountToDiscount;

    HalfPriceDiscount(Product product, int amountToDiscount) {
        this.product = product;
        this.amountToDiscount = amountToDiscount;
    }

    @Override
    public int calculateDiscount(Basket basket) {
        int quantity = basket.query().quantity(product.getName());
        int quantityToDiscount = min(amountToDiscount, quantity);
        int halfPrice = product.getPriceInPence() / 2;
        return halfPrice * quantityToDiscount;
    }
}
