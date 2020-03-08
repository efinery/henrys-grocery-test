package com.henrys.product;

public class Product {
    private final String name;
    private final String unit;
    private final int priceInPence;

    Product(String name, String unit, int priceInPence) {
        this.name = name;
        this.unit = unit;
        this.priceInPence = priceInPence;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public int getPriceInPence() {
        return priceInPence;
    }
}
