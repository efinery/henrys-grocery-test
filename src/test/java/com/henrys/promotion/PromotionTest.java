package com.henrys.promotion;

import org.junit.Test;

import java.time.LocalDate;

import static com.henrys.promotion.DateRange.newDateRange;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PromotionTest {
    private final LocalDate today = LocalDate.now();
    private final LocalDate tomorrow = today.plusDays(1);

    @Test
    public void should_not_be_valid_when_current_date_before_promotion_start() {
        Promotion promotion = create(newDateRange().starting(today).ending(tomorrow));

        assertFalse(promotion.isValidFor(today.minusDays(1)));
    }

    @Test
    public void should_not_be_valid_when_current_date_after_promotion_end() {
        Promotion promotion = create(newDateRange().starting(today).ending(tomorrow));

        assertFalse(promotion.isValidFor(today.plusDays(2)));
    }

    @Test
    public void should_be_valid_when_current_date_same_as_promotion_start() {
        Promotion promotion = create(newDateRange().starting(today).ending(tomorrow));

        assertTrue(promotion.isValidFor(today));
    }

    @Test
    public void should_be_valid_when_current_date_same_as_promotion_end() {
        Promotion promotion = create(newDateRange().starting(today).ending(tomorrow));

        assertTrue(promotion.isValidFor(tomorrow));
    }

    @Test
    public void should_be_valid_when_current_date_between_promotion_dates() {
        LocalDate nextWeek = today.plusWeeks(1);
        Promotion promotion = create(newDateRange().starting(today).ending(nextWeek));

        assertTrue(promotion.isValidFor(today.plusDays(1)));
    }

    private Promotion create(DateRange.Builder builder) {
        return new Promotion(builder.build(), null);
    }
}