package com.henrys;

import com.henrys.product.ProductRepository;
import com.henrys.product.ProductRepositoryFactory;
import com.henrys.promotion.PromotionRepository;
import com.henrys.promotion.PromotionRepositoryFactory;

public class BasketTotallerFactory {

    public BasketTotaller create() {
        ProductRepository productRepository = new ProductRepositoryFactory().create();
        PromotionRepository promotionRepository = new PromotionRepositoryFactory().create();
        return new BasketTotaller(productRepository, promotionRepository);
    }
}
