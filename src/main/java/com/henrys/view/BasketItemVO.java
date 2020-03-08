package com.henrys.view;

class BasketItemVO {
    private final String name;
    private final String unit;
    private final int unitPrice;
    private final int quantity;

    BasketItemVO(String name, String unit, int unitPrice, int quantity) {
        this.name = name;
        this.unit = unit;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    String getName() {
        return name;
    }

    String getUnit() {
        return unit;
    }

    int getUnitPrice() {
        return unitPrice;
    }

    int getQuantity() {
        return quantity;
    }
}
