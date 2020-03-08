package com.henrys.view;

import java.io.PrintWriter;
import java.math.BigDecimal;

import static java.lang.String.format;
import static java.math.BigDecimal.valueOf;

public class BasketSummaryRenderer {
    private final PrintWriter writer;

    public BasketSummaryRenderer(PrintWriter writer) {
        this.writer = writer;
    }

    public void render(BasketSummaryVO summaryVO) {
        writer.println("    Item    Price /     Unit   Qty");
        writer.println("-------- ------------------- -----");

        for (BasketItemVO itemVO : summaryVO.getItems()) {
            writer.print(format("%-8s", itemVO.getName()));
            writer.print(" ");
            writer.print(format("%8s", mapPrice(itemVO.getUnitPrice())));
            writer.print(" / ");
            writer.print(format("%8s", itemVO.getUnit()));
            writer.print(" ");
            writer.print(format("%5d", itemVO.getQuantity()));
            writer.println();
        }
        writer.println();
        writer.println("Discounts : £" + mapPrice(summaryVO.getDiscountTotal()));
        writer.println("TOTAL     : £" + mapPrice(summaryVO.getTotal()));
    }


    private BigDecimal mapPrice(int pence) {
        return valueOf(pence)
                .divide(valueOf(100))
                .setScale(2);
    }
}
