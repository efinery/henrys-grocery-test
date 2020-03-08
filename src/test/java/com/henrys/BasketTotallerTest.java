package com.henrys;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static com.henrys.product.ProductListBuilder.newBasket;
import static org.junit.Assert.assertEquals;

public class BasketTotallerTest {
    private BasketTotaller totaller;

    @Before
    public void setUp() throws Exception {
        totaller = new BasketTotallerFactory().create();
    }

    @Test
    public void should_calculate_one_of_everything() throws Exception {
        List<String> products = newBasket().withSoup().withBread().withMilk().withApple().build();

        int total = totaller.total(products, LocalDate.now());

        assertEquals(285, total);
    }

    @Test
    public void should_discount_bread_with_2_soup() throws Exception {
        List<String> products = newBasket().withSoup(2).withBread().build();

        int total = totaller.total(products, LocalDate.now());

        assertEquals(170, total);
    }

    @Test
    public void should_discount_apples() throws Exception {
        List<String> products = newBasket().withApple().build();

        int total = totaller.total(products, LocalDate.now().plusDays(3));

        assertEquals(9, total);
    }

}