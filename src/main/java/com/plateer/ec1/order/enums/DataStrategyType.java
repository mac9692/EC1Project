package com.plateer.ec1.order.enums;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DataStrategyType {
    GENERAL("10"),
    ECOUPON("20");

    private final String type;

    public String getType() {
        return type;
    }
}
