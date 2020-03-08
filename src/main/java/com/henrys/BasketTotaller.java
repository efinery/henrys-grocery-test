package com.henrys;

import com.henrys.basket.Basket;
import com.henrys.basket.BasketFactory;
import com.henrys.basket.BasketQuery;
import com.henrys.promotion.DiscountCollector;
import com.henrys.promotion.Promotion;
import com.henrys.promotion.PromotionRepository;

import java.time.LocalDate;
import java.util.List;

public class BasketTotaller {
    private final BasketFactory basketFactory;
    private final PromotionRepository promotionRepository;

    public BasketTotaller(BasketFactory basketFactory,
                          PromotionRepository promotionRepository) {
        this.basketFactory = basketFactory;
        this.promotionRepository = promotionRepository;
    }

    public int total(List<String> productNames, LocalDate date) {
        Basket basket = basketFactory.create(productNames);
        DiscountCollector discountCollector = new DiscountCollector();

        List<Promotion> promotions = promotionRepository.find(date);
        for (Promotion promotion : promotions) {
            promotion.getRule().check(basket, discountCollector);
        }

        int basketTotal = calulateTotal(basket);
        int discountTotal = discountCollector.totalDiscount(basket);
        return basketTotal - discountTotal;
    }

    private int calulateTotal(Basket basket) {
        BasketQuery basketQuery = new BasketQuery(basket);
        return basketQuery.total();
    }

}
