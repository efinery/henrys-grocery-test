package com.henrys;

import com.henrys.basket.Basket;
import com.henrys.basket.BasketFactory;
import com.henrys.promotion.DiscountProcessor;
import com.henrys.view.BasketSummaryMapper;
import com.henrys.view.BasketSummaryVO;

import java.time.LocalDate;
import java.util.List;

public class BasketTotaller {
    private final BasketFactory basketFactory;
    private final DiscountProcessor discountProcessor;
    private final BasketSummaryMapper basketSummaryMapper;

    BasketTotaller(BasketFactory basketFactory,
                   DiscountProcessor discountProcessor,
                   BasketSummaryMapper basketSummaryMapper) {
        this.basketFactory = basketFactory;
        this.discountProcessor = discountProcessor;
        this.basketSummaryMapper = basketSummaryMapper;
    }

    public BasketSummaryVO total(List<String> productNames, LocalDate date) {
        Basket basket = basketFactory.create(productNames, date);
        int basketTotal = basket.query().total();
        int discountTotal = discountProcessor.calculateDiscounts(basket);
        int total = basketTotal - discountTotal;
        return basketSummaryMapper.map(basket, total, discountTotal);
    }

}
