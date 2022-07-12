package com.plateer.ec1.common.code.order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OPT0011 {
    PAYMENT_REQUEST("10"),
    PAYMENT_COMPLETE("20"),
    REFUND_COMPLETE("30");

    private String type;

    public String getType() {
        return type;
    }
}
