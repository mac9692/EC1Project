package com.plateer.ec1.common.code.promotion;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PRM0012 {
    FIRST("1"),
    SECONDARY("2"),
    THIRD("3"),
    FOURTH("4");

    private String type;

    public String getType() {
        return type;
    }
}
