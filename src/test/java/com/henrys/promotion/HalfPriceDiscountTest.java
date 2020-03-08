package com.henrys.promotion;

import com.henrys.product.Product;
import com.henrys.product.ProductRepository;
import com.henrys.product.ProductRepositoryFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HalfPriceDiscountTest {
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        productRepository = new ProductRepositoryFactory().create();
    }

    @Test
    public void should_discount_one_loaf() {
        int discount = discountLoaves(1);

        assertEquals(40, discount);
    }

    @Test
    public void should_discount_two_loaves() {
        int discount = discountLoaves(2);

        assertEquals(80, discount);
    }

    private int discountLoaves(int numberOfLoaves) {
        Product bread = productRepository.findByName("bread");
        HalfPriceDiscount discount = new HalfPriceDiscount(bread, numberOfLoaves);
        return discount.calculateDiscount(null);
    }
}