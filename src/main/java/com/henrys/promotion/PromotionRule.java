package com.henrys.promotion;

import java.util.List;

public interface PromotionRule {

    void check(List<String> products);
}
