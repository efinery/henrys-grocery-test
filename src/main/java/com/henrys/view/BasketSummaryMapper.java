package com.henrys.view;

import com.henrys.basket.Basket;
import com.henrys.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class BasketSummaryMapper {

    public BasketSummaryVO map(Basket basket, int total, int discountTotal) {
        List<BasketItemVO> items = mapItems(basket);
        return new BasketSummaryVO(items, total, discountTotal);
    }

    private List<BasketItemVO> mapItems(Basket basket) {
        List<BasketItemVO> items = new ArrayList<>();

        Map<Product, Long> grouped = basket.getProducts()
                .stream()
                .collect(groupingBy(identity(), counting()));

        for (Map.Entry<Product, Long> entry : grouped.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue().intValue();
            items.add(new BasketItemVO(product.getName(), product.getUnit(), product.getPriceInPence(), quantity));
        }
        return items;
    }
}
