package com.henrys;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static java.math.BigDecimal.valueOf;

public class Application {

    public static void main(String[] args) {
        List<String> productNames = Arrays.asList(args);

        BasketTotaller basketTotaller = new BasketTotallerFactory().create();
        int total = basketTotaller.total(productNames, LocalDate.now());

        System.out.println("Basket : " + productNames);
        System.out.println("Total is £" + map(total));
    }

    private static BigDecimal map(int pence) {
        return valueOf(pence)
                .divide(valueOf(100))
                .setScale(2);
    }

}
