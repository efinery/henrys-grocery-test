package com.henrys;

import com.henrys.basket.Basket;
import com.henrys.basket.BasketFactory;
import com.henrys.basket.BasketQuery;
import com.henrys.promotion.DiscountProcessor;

import java.time.LocalDate;
import java.util.List;

public class BasketTotaller {
    private final BasketFactory basketFactory;
    private final DiscountProcessor discountProcessor;

    BasketTotaller(BasketFactory basketFactory,
                   DiscountProcessor discountProcessor) {
        this.basketFactory = basketFactory;
        this.discountProcessor = discountProcessor;
    }

    public int total(List<String> productNames, LocalDate date) {
        Basket basket = basketFactory.create(productNames, date);
        int basketTotal = calulateTotal(basket);
        int discountTotal = discountProcessor.calculateDiscounts(basket);
        return basketTotal - discountTotal;
    }

    private int calulateTotal(Basket basket) {
        BasketQuery basketQuery = new BasketQuery(basket);
        return basketQuery.total();
    }
}
