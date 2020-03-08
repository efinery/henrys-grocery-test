package com.henrys;

import com.henrys.basket.BasketFactory;
import com.henrys.product.ProductRepository;
import com.henrys.product.ProductRepositoryFactory;
import com.henrys.promotion.PromotionRepository;
import com.henrys.promotion.PromotionRepositoryFactory;

public class BasketTotallerFactory {

    public BasketTotaller create() {
        ProductRepository productRepository = new ProductRepositoryFactory().create();
        BasketFactory basketFactory = new BasketFactory(productRepository);
        PromotionRepository promotionRepository = new PromotionRepositoryFactory(productRepository).create();
        return new BasketTotaller(basketFactory, promotionRepository);
    }
}
