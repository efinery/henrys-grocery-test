package com.henrys.product;

public class NoSuchProductException extends RuntimeException {

    NoSuchProductException(String productName) {
        super("No such product '" + productName + "'");
    }
}
