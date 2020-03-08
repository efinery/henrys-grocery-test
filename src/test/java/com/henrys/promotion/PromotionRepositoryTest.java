package com.henrys.promotion;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.henrys.promotion.DateRange.newDateRange;
import static java.time.LocalDate.now;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class PromotionRepositoryTest {
    private PromotionRepository repository;
    private PromotionRule thisWeekRule;
    private PromotionRule thisMonthRule;

    @Before
    public void setUp() {
        thisWeekRule = (basket, discountCollector) -> {
        };
        thisMonthRule = (basket, discountCollector) -> {
        };

        DateRange thisWeekRange = newDateRange()
                .starting(now())
                .ending(now().plusWeeks(1))
                .build();
        Promotion thisWeekPromo = new Promotion(thisWeekRange, thisWeekRule);

        DateRange thisMonthRange = newDateRange()
                .starting(now().withDayOfMonth(1))
                .ending(now().plusMonths(1).withDayOfMonth(1).minusDays(1))
                .build();
        Promotion thisMonthPromo = new Promotion(thisMonthRange, thisMonthRule);

        List<Promotion> promotions = asList(thisWeekPromo, thisMonthPromo);
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