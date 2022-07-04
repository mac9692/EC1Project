package com.plateer.ec1.common.code.promotion;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PRM0004 {

    PRODUCT_COUPON("10"),
    OVERLAP_COUPON("20"),
    CART_COUPON("30");

    private String type;

    public String getType() {
        return type;
    }
}
