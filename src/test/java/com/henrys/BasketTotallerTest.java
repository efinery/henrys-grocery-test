package com.henrys;

import com.henrys.product.ProductRepository;
import com.henrys.product.ProductRepositoryFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static com.henrys.product.ProductListBuilder.newBasket;
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
        List<String> products = newBasket().withSoup().withBread().withMilk().withApple().build();

        int total = totaller.total(products);

        assertEquals(285, total);
    }

    @Ignore
    @Test
    public void should_discount_bread_with_2_soup() throws Exception {
        List<String> products = newBasket().withSoup(2).withBread().build();

        int total = totaller.total(products);

        assertEquals(170, total);
    }

}