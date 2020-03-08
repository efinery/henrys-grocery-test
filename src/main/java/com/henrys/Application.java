package com.henrys;

import com.henrys.view.BasketSummaryRenderer;
import com.henrys.view.BasketSummaryVO;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<String> productNames = Arrays.asList(args);

        BasketTotaller basketTotaller = new BasketTotallerFactory().create();
        BasketSummaryVO summaryVO = basketTotaller.total(productNames, LocalDate.now());

        try (PrintWriter writer = new PrintWriter(System.out, true)) {
            BasketSummaryRenderer renderer = new BasketSummaryRenderer(writer);
            renderer.render(summaryVO);
        }
    }
}
