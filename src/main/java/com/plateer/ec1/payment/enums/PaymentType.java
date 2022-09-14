package com.plateer.ec1.payment.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PaymentType {
    INICIS("10"),
    POINT("20");

    private String type;

    public String getType() {
        return type;
    }
}
