package com.plateer.ec1.common.code.promotion;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PRM0007 {

    NONE("N"),
    MAIL("M"),
    SMS("S"),
    PUSH("P"),
    HOMEPAGE("H");

    private String type;
}
