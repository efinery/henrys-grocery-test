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

    @Before
    public void setUp() throws Exception {
        thisWeek = new Promotion(now(), now().plusWeeks(1));
        thisMonth = new Promotion(
                now().withDayOfMonth(1),
                now().plusMonths(1).withDayOfMonth(1).minusDays(1)
        );

        List<Promotion> promotions = asList(thisWeek, thisMonth);
        repository = new PromotionRepository(promotions);
    }

    @Test
    public void should_find_no_promotions() throws Exception {
        List<Promotion> promotions = repository.find(now().plusYears(1));

        assertTrue(promotions.isEmpty());
    }

    @Test
    public void should_find_both_promotions() throws Exception {
        List<Promotion> promotions = repository.find(now());

        assertEquals(2, promotions.size());
        assertSame(thisWeek, promotions.get(0));
        assertSame(thisMonth, promotions.get(1));
    }

    @Test
    public void should_find_this_months_promotion() throws Exception {
        List<Promotion> promotions = repository.find(now().plusWeeks(2));

        assertEquals(1, promotions.size());
        assertSame(thisMonth, promotions.get(0));
    }

}