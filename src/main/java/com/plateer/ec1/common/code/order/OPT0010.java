package com.plateer.ec1.common.code.order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OPT0010 {
    PAYMENT("10"),
    CANCEL("20");

    private final String type;

    public String getType() {
        return type;
    }
}
