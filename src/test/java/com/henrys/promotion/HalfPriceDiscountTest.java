package com.henrys.promotion;

import com.henrys.product.Product;
import com.henrys.product.ProductRepository;
import com.henrys.product.ProductRepositoryFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HalfPriceDiscountTest {
    private HalfPriceDiscount halfPriceDiscount;

    @Before
    public void setUp() throws Exception {
        ProductRepository productRepository = new ProductRepositoryFactory().create();
        Product bread = productRepository.findByName("bread");
        halfPriceDiscount = new HalfPriceDiscount(bread, 1);
    }

    @Test
    public void calculateDiscount() throws Exception {
        int discount = halfPriceDiscount.calculateDiscount();

        assertEquals(40, discount);
    }

}