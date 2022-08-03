package com.plateer.ec1.common.code.order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OPT0008 {
    CUSTOMER("10"),
    COMPANY("20");
    private final String type;

    public String getType() {
        return type;
    }
}
