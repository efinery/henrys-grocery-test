package com.henrys.view;

import java.util.List;

public class BasketSummaryVO {
    private final List<BasketItemVO> items;
    private final int total;
    private final int discountTotal;

    BasketSummaryVO(List<BasketItemVO> items, int total, int discountTotal) {
        this.items = items;
        this.total = total;
        this.discountTotal = discountTotal;
    }

    public List<BasketItemVO> getItems() {
        return items;
    }

    public int getTotal() {
        return total;
    }

    public int getDiscountTotal() {
        return discountTotal;
    }
}
