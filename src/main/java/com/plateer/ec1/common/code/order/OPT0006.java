package com.plateer.ec1.common.code.order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OPT0006 {
    DELIVERY_CHARGE("10"),
    RETURN_CHARGE("20"),
    CHANGE_DELIVERY_CHARGE("30"),
    MOUNTAIN_COUNTRY("40");
    private final String type;

    public String getType() {
        return type;
    }
}
