package com.plateer.ec1.common.code.product;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PRD0002 {
    DELIVERY("10"),
    NON_DELIVERY("20");

    private String type;

    public String getType() {
        return type;
    }
}
