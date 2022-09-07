package com.plateer.ec1.common.code.product;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DVP0002 {
    FREE("10"),
    CHARGED("20"),
    COLLECTIBLE("30");

    private String type;

    public String getType() {
        return type;
    }
}
