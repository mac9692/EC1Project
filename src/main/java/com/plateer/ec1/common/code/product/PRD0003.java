package com.plateer.ec1.common.code.product;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PRD0003 {
    BEFORE_APPROVE("10"),
    ON_SALE("20"),
    PAUSE("30"),
    PERMANENT_SUSPENSION("40");

    private String type;

    public String getType() {
        return type;
    }
}
