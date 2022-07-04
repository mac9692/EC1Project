package com.plateer.ec1.common.code.promotion;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PRM0003 {

    FIXED_DISCOUNT("10"),
    RATE_DISCOUNT("20");

    private String type;

    public String getType() {
        return type;
    }
}
