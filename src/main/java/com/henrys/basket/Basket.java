package com.henrys.basket;

import com.henrys.product.Product;

import java.time.LocalDate;
import java.util.List;

public class Basket {
    private final List<Product> products;
    private final LocalDate created;

    Basket(List<Product> products, LocalDate created) {
        this.products = products;
        this.created = created;
    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDate getCreated() {
        return created;
    }
}
