package com.henrys.basket;

import com.henrys.product.Product;
import com.henrys.product.ProductRepository;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BasketFactory {
    private final ProductRepository productRepository;

    public BasketFactory(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Basket create(List<String> productNames, LocalDate date) {
        List<Product> products = productNames.stream()
                .map(p -> productRepository.findByName(p))
                .collect(toList());
        return new Basket(products, date);
    }
}
