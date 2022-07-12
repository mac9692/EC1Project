package com.plateer.ec1.common.code.order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OPT0013 {
    IBK("03"),
    KB("04"),
    NH("11");

    private String type;

    public String getType() {
        return type;
    }
}
