package com.henrys.promotion;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PromotionTest {

    @Test
    public void should_not_be_valid_when_current_date_before_promotion_start() throws Exception {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        Promotion promotion = new Promotion(today, tomorrow);

        assertFalse(promotion.isValidFor(today.minusDays(1)));
    }

    @Test
    public void should_not_be_valid_when_current_date_after_promotion_end() throws Exception {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        Promotion promotion = new Promotion(today, tomorrow);

        assertFalse(promotion.isValidFor(today.plusDays(2)));
    }

    @Test
    public void should_be_valid_when_current_date_same_as_promotion_start() throws Exception {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        Promotion promotion = new Promotion(today, tomorrow);

        assertTrue(promotion.isValidFor(today));
    }

    @Test
    public void should_be_valid_when_current_date_same_as_promotion_end() throws Exception {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        Promotion promotion = new Promotion(today, tomorrow);

        assertTrue(promotion.isValidFor(tomorrow));
    }

    @Test
    public void should_be_valid_when_current_date_between_promotion_dates() throws Exception {
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusWeeks(1);
        Promotion promotion = new Promotion(today, nextWeek);

        assertTrue(promotion.isValidFor(today.plusDays(1)));
    }

}