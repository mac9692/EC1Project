package com.plateer.ec1.common.code.order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OPT0009 {
    VIRTUAL_ACCOUNT("10"),
    POINT("20");

    private final String type;

    public String getType() {
        return type;
    }
}
