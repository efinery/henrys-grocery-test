package com.henrys;

import com.henrys.basket.Basket;
import com.henrys.basket.BasketFactory;
import com.henrys.product.Product;
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

        List<Promotion> promotions = promotionRepository.find(date);
        for (Promotion promotion : promotions) {
            promotion.getRule().check(basket);
        }

        return calulateTotal(basket);
    }

    private int calulateTotal(Basket basket) {
        int total = 0;

        for (Product product : basket.getProducts()) {
            total += product.getPriceInPence();
        }

        return total;
    }
}
