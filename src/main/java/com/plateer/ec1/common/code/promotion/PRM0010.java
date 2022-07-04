package com.plateer.ec1.common.code.promotion;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PRM0010 {

    PRODUCT("10"),
    EXHIBITIONS("20"),
    DISPLAY_CATEGORY("30"),
    COMPANY("40");

    private String type;

    public String getType() {
        return type;
    }
}
