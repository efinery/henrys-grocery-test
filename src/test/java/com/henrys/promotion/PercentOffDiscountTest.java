package com.henrys.promotion;

import com.henrys.basket.Basket;
import com.henrys.basket.BasketFactory;
import com.henrys.product.Product;
import com.henrys.product.ProductRepository;
import com.henrys.product.ProductRepositoryFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.henrys.product.ProductListBuilder.newBasket;
import static org.junit.Assert.assertEquals;

public class PercentOffDiscountTest {
    private ProductRepository productRepository;
    private BasketFactory basketFactory;

    @Before
    public void setUp() throws Exception {
        productRepository = new ProductRepositoryFactory().create();
        basketFactory = new BasketFactory(productRepository);
    }

    @Test
    public void should_discount_one_apple() throws Exception {
        List<String> apples = newBasket().withApple().build();
        Basket basket = basketFactory.create(apples);

        int discount = discountApplesByTenPercent(basket);

        assertEquals(1, discount);
    }

    @Test
    public void should_discount_ten_apples() throws Exception {
        List<String> apples = newBasket().withApples(10).build();
        Basket basket = basketFactory.create(apples);

        int discount = discountApplesByTenPercent(basket);

        assertEquals(10, discount);
    }

    private int discountApplesByTenPercent(Basket basket) {
        Product apples = productRepository.findByName("apples");
        PercentOffDiscount discount = new PercentOffDiscount(apples, 10);
        return discount.calculateDiscount(basket);
    }
}