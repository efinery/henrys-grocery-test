package com.henrys;

import com.henrys.product.ProductListBuilder;
import com.henrys.view.BasketSummaryVO;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static com.henrys.product.ProductListBuilder.newBasket;
import static org.junit.Assert.assertEquals;

public class BasketTotallerTest {
    private final LocalDate today = LocalDate.now();
    private BasketTotaller totaller;

    @Before
    public void setUp() {
        totaller = new BasketTotallerFactory().create();
    }

    @Test
    public void should_calculate_one_of_everything() {
        int total = price(newBasket().withSoup().withBread().withMilk().withApple(), today);

        assertEquals(285, total);
    }

    @Test
    public void should_discount_bread_with_2_soup() {
        int total = price(newBasket().withSoup(2).withBread(), today);

        assertEquals(170, total);
    }

    @Test
    public void should_discount_apples() {
        int total = price(newBasket().withApple(), today.plusDays(3));

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

    @Test
    public void should_not_discount_apples_before_promotion() {
        int total = price(newBasket().withApple(), today.plusDays(2));

        assertEquals(10, total);
    }

    @Test
    public void should_not_discount_apples_after_promotion() {
        int total = price(newBasket().withApple(), today.plusMonths(2).withDayOfMonth(1));

        assertEquals(10, total);
    }

    @Test
    public void should_not_discount_bread_before_promotion() {
        int total = price(newBasket().withSoup(2).withBread(), today.minusDays(2));

        assertEquals(210, total);
    }

    @Test
    public void should_not_discount_bread_after_promotion() {
        int total = price(newBasket().withSoup(2).withBread(), today.plusDays(7));

        assertEquals(210, total);
    }

    @Test
    public void should_not_apply_multiple_discounts_to_single_loaf_of_bread() {
        int total = price(newBasket().withSoup(4).withBread(), today);

        assertEquals(300, total);
    }

    private int price(ProductListBuilder builder, LocalDate createdOn) {
        List<String> products = builder.build();
        BasketSummaryVO summaryVO = totaller.total(products, createdOn);
        return summaryVO.getTotal();
    }
}