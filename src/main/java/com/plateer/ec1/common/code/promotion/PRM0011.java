package com.plateer.ec1.common.code.promotion;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PRM0011 {
    SAVE("10"),
    USE("20");

    private String type;

    public String getType() {
        return type;
    }
}
