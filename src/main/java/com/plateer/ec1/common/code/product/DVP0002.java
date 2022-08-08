package com.plateer.ec1.common.code.product;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DVP0002 {
    FREE("10");

    private String type;

    public String getType() {
        return type;
    }
}
