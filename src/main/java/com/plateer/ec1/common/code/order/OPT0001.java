package com.plateer.ec1.common.code.order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OPT0001 {
    GENERAL("10"),
    MOBILE_COUPON("20");

    private final String type;

    public String getType() {
        return type;
    }
}
