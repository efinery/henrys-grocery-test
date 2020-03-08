package com.henrys;

import com.henrys.product.ProductRepository;
import com.henrys.product.ProductRepositoryFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BasketTotallerTest {
    private BasketTotaller totaller;

    @Before
    public void setUp() throws Exception {
        ProductRepository productRepository = new ProductRepositoryFactory().create();
        totaller = new BasketTotaller(productRepository);
    }

    @Test
    public void should_calculate_one_of_everything() throws Exception {
        List<String> products = Arrays.asList("soup", "bread", "milk", "apples");

        int total = totaller.total(products);

        assertEquals(285, total);
    }
}