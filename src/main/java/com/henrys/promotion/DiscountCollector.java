package com.henrys.promotion;

import java.util.ArrayList;
import java.util.List;

public class DiscountCollector {
    private final List<Discount> discounts = new ArrayList<>();

    public void add(Discount discount) {
        this.discounts.add(discount);
    }

    public int totalDiscount() {
        int total = 0;
        for (Discount discount : discounts) {
            total += discount.calculateDiscount();
        }
        return total;
    }
}
