package com.plateer.ec1.order.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AfterStrategyType {
    FO("10"),
    BO("20");

    private final String type;

    public String getType() {
        return type;
    }
}
