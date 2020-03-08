package com.henrys.basket;

import com.henrys.product.Product;
import com.henrys.product.ProductRepository;
import com.henrys.product.ProductRepositoryFactory;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class BasketFactoryTest {
    private BasketFactory factory;

    @Before
    public void setUp() {
        ProductRepository repository = new ProductRepositoryFactory().create();
        factory = new BasketFactory(repository);
    }

    @Test
    public void create() {
        Basket basket = factory.create(asList("soup", "milk"), LocalDate.now());

        List<Product> products = basket.getProducts();
        assertEquals("soup", products.get(0).getName());
        assertEquals("milk", products.get(1).getName());
    }

}