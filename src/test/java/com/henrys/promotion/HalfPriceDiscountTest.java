package com.henrys.promotion;

import com.henrys.basket.Basket;
import com.henrys.basket.BasketFactory;
import com.henrys.product.Product;
import com.henrys.product.ProductListBuilder;
import com.henrys.product.ProductRepository;
import com.henrys.product.ProductRepositoryFactory;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static com.henrys.product.ProductListBuilder.newBasket;
import static org.junit.Assert.assertEquals;

public class HalfPriceDiscountTest {
    private ProductRepository productRepository;
    private BasketFactory basketFactory;

    @Before
    public void setUp() {
        productRepository = new ProductRepositoryFactory().create();
        basketFactory = new BasketFactory(productRepository);
    }

    @Test
    public void should_discount_one_loaf() {
        Basket basket = basket(newBasket().withBread());

        int discount = discountLoaves(basket, 1);

        assertEquals(40, discount);
    }

    @Test
    public void should_discount_two_loaves() {
        Basket basket = basket(newBasket().withBread(2));

        int discount = discountLoaves(basket, 2);

        assertEquals(80, discount);
    }

    @Test
    public void should_discount_only_one_loaf_when_discount_has_multiple_loaves() {
        Basket basket = basket(newBasket().withBread());

        int discount = discountLoaves(basket, 99);

        assertEquals(40, discount);
    }

    private int discountLoaves(Basket basket, int numberOfLoaves) {
        Product bread = productRepository.findByName("bread");
        HalfPriceDiscount discount = new HalfPriceDiscount(bread, numberOfLoaves);
        return discount.calculateDiscount(basket);
    }


    private Basket basket(ProductListBuilder builder) {
        List<String> products = builder.build();
        return basketFactory.create(products, LocalDate.now());
    }
}