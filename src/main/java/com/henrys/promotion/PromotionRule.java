package com.henrys.promotion;

import com.henrys.basket.Basket;

public interface PromotionRule {

    void check(Basket basket);
}
