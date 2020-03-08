package com.henrys.promotion;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.time.LocalDate.now;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class PromotionRepositoryTest {
    private PromotionRepository repository;
    private Promotion thisWeek;
    private Promotion thisMonth;
    private PromotionRule thisWeekRule;
    private PromotionRule thisMonthRule;

    @Before
    public void setUp() {
        thisWeekRule = (basket, discountCollector) -> {
        };
        thisMonthRule = (basket, discountCollector) -> {
        };

        thisWeek = new Promotion(now(), now().plusWeeks(1), thisWeekRule);
        thisMonth = new Promotion(
                now().withDayOfMonth(1),
                now().plusMonths(1).withDayOfMonth(1).minusDays(1),
                thisMonthRule);

        List<Promotion> promotions = asList(thisWeek, thisMonth);
        repository = new PromotionRepository(promotions);
    }

    @Test
    public void should_find_no_promotions() {
        List<PromotionRule> promotionRules = repository.find(now().plusYears(1));

        assertTrue(promotionRules.isEmpty());
    }

    @Test
    public void should_find_both_promotions() {
        List<PromotionRule> promotionRules = repository.find(now());

        assertEquals(2, promotionRules.size());
        assertSame(thisWeekRule, promotionRules.get(0));
        assertSame(thisMonthRule, promotionRules.get(1));
    }

    @Test
    public void should_find_this_months_promotion() {
        List<PromotionRule> promotionRules = repository.find(now().plusWeeks(2));

        assertEquals(1, promotionRules.size());
        assertSame(thisMonthRule, promotionRules.get(0));
    }

}