package com.henrys.promotion;

import com.henrys.product.Product;

public class HalfPriceDiscount implements Discount {
    private final Product product;
    private final int amountToDiscount;

    public HalfPriceDiscount(Product product, int amountToDiscount) {
        this.product = product;
        this.amountToDiscount = amountToDiscount;
    }

    @Override
    public int calculateDiscount() {
        int halfPrice = product.getPriceInPence() / 2;
        return halfPrice * amountToDiscount;
    }
}
