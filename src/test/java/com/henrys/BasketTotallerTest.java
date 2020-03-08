package com.henrys;

import com.henrys.product.ProductListBuilder;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static com.henrys.product.ProductListBuilder.newBasket;
import static org.junit.Assert.assertEquals;

public class BasketTotallerTest {
    private BasketTotaller totaller;
    private final LocalDate today = LocalDate.now();

    @Before
    public void setUp() {
        totaller = new BasketTotallerFactory().create();
    }

    @Test
    public void should_calculate_one_of_everything() {
        List<String> products = newBasket().withSoup().withBread().withMilk().withApple().build();

        int total = totaller.total(products, today);

        assertEquals(285, total);
    }

    @Test
    public void should_discount_bread_with_2_soup() {
        List<String> products = newBasket().withSoup(2).withBread().build();

        int total = totaller.total(products, today);

        assertEquals(170, total);
    }

    @Test
    public void should_discount_apples() {
        List<String> products = newBasket().withApple().build();

        int total = totaller.total(products, today.plusDays(3));

        assertEquals(9, total);
    }

    @Test
    public void should_price_3_soup_2_bread_today() {
        int total = price(newBasket()
                        .withSoup(3)
                        .withBread(2),
                today);

        assertEquals(315, total);
    }

    @Test
    public void should_price_6_apples_1_milk_today() {
        int total = price(newBasket()
                        .withApples(6)
                        .withMilk(),
                today);

        assertEquals(190, total);
    }

    @Test
    public void should_price_6_apples_1_milk_5_days_from_today() {
        LocalDate fiveDaysFromNow = today.plusDays(5);

        int total = price(newBasket()
                        .withApples(6)
                        .withMilk(),
                fiveDaysFromNow);

        assertEquals(184, total);
    }

    @Test
    public void should_price_3_apples_2_soup_1_bread_5_days_from_today() {
        LocalDate fiveDaysFromNow = today.plusDays(5);

        int total = price(newBasket()
                        .withApples(3)
                        .withSoup(2)
                        .withBread(),
                fiveDaysFromNow);

        assertEquals(197, total);
    }

    private int price(ProductListBuilder builder, LocalDate createdOn) {
        List<String> products = builder.build();
        return totaller.total(products, createdOn);
    }
}