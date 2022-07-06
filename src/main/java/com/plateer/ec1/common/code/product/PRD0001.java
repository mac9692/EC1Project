package com.plateer.ec1.common.code.product;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PRD0001 {

    GENERAL_PRODUCT("10"),
    MOBILE_COUPON("20");

    private String type;

    public String getType() {
        return type;
    }
}
