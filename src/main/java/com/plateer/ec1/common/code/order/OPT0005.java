package com.plateer.ec1.common.code.order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OPT0005 {
    APPLY("APLY"),
    CANCEL("CNCL");
    private final String type;

    public String getType() {
        return type;
    }
}
