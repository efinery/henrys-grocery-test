package com.henrys.promotion;

import com.henrys.basket.Basket;

import java.util.ArrayList;
import java.util.List;

public class DiscountCollector {
    private final List<Discount> discounts = new ArrayList<>();

    public void add(Discount discount) {
        this.discounts.add(discount);
    }

    public int totalDiscount(Basket basket) {
        int total = 0;
        for (Discount discount : discounts) {
            total += discount.calculateDiscount(basket);
        }
        return total;
    }
}
