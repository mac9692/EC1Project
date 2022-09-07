package com.plateer.ec1.common.code.product;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DVP0001 {
    DELIVERY("10"),
    DELIVERY_WITHDRAW("20");

    private String type;

    public String getType() {
        return type;
    }
}
