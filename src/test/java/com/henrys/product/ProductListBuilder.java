package com.henrys.product;

import java.util.ArrayList;
import java.util.List;

public class ProductListBuilder {
    private final List<String> products = new ArrayList<>();

    private ProductListBuilder() {
    }

    public static ProductListBuilder newBasket() {
        return new ProductListBuilder();
    }

    public ProductListBuilder withSoup() {
        return withSoup(1);
    }

    public ProductListBuilder withSoup(int quantity) {
        add("soup", quantity);
        return this;
    }

    public ProductListBuilder withBread() {
        return withBread(1);
    }

    public ProductListBuilder withBread(int quantity) {
        add("bread", quantity);
        return this;
    }

    public ProductListBuilder withMilk() {
        return withMilk(1);
    }

    public ProductListBuilder withMilk(int quantity) {
        add("milk", quantity);
        return this;
    }

    public ProductListBuilder withApple() {
        return withApples(1);
    }

    public ProductListBuilder withApples(int quantity) {
        add("apples", quantity);
        return this;
    }

    private void add(String name) {
        products.add(name);
    }

    private void add(String name, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(name);
        }
    }

    public List<String> build() {
        return products;
    }
}
