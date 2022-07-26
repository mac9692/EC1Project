package com.plateer.ec1.common.code.order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OPT0002 {
    FO("10"),
    BO("20");

    private String type;

    public String getType() {
        return type;
    }
}
