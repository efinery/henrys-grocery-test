package com.henrys.product;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductRepositoryTest {
    private ProductRepository repository;

    @Before
    public void setUp() {
        repository = new ProductRepositoryFactory().create();
    }

    @Test
    public void should_have_correct_price_for_soup() {
        Product soup = repository.findByName("soup");

        assertEquals(65, soup.getPriceInPence());
    }

    @Test
    public void should_have_correct_price_for_bread() {
        Product bread = repository.findByName("bread");

        assertEquals(80, bread.getPriceInPence());
    }

    @Test
    public void should_have_correct_price_for_milk() {
        Product milk = repository.findByName("milk");

        assertEquals(130, milk.getPriceInPence());
    }

    @Test
    public void should_have_correct_price_for_apples() {
        Product apples = repository.findByName("apples");

        assertEquals(10, apples.getPriceInPence());
    }

    @Test(expected = NoSuchProductException.class)
    public void should_fail_for_unknown_product() {
        repository.findByName("unknown");
    }

}