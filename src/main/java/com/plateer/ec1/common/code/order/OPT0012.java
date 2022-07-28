package com.plateer.ec1.common.code.order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OPT0012 {
    SUCCESS("S"),
    DATA_CREATE("FD"),
    VALIDATION_CHECK("FV"),
    PAYMENT("FP");

    private String type;

    public String getType() {
        return type;
    }
}
