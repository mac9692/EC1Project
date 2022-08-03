package com.plateer.ec1.common.code.order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OPT0004 {
    ORDER_COMPLETE("10"),
    CANCEL_REQUEST("20"),
    CANCEL_COMPLETE("30"),
    DELIVERY_COMPLETE("40"),
    RETURN_REQUEST("50"),
    ORDER_WAIT("60"),
    EXCHANGE_REQUEST("70"),
    RETURN_WITHDRAWAL_COMPLETE("80");
    private String type;

    public String getType() {
        return type;
    }
}
