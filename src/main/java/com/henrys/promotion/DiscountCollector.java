package com.henrys.promotion;

import com.henrys.basket.Basket;

import java.util.ArrayList;
import java.util.List;

class DiscountCollector {
    private final List<Discount> discounts = new ArrayList<>();

    void add(Discount discount) {
        this.discounts.add(discount);
    }

    int totalDiscount(Basket basket) {
        int total = 0;
        for (Discount discount : discounts) {
            total += discount.calculateDiscount(basket);
        }
        return total;
    }
}
