package com.plateer.ec1.common.code.order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OPT0007 {
    CHANGE_MIND("10"),
    PRODUCT_DAMAGE("20"),
    ETC("99");

    private final String type;

    public String getType() {
        return type;
    }
}
