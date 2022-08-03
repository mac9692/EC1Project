package com.plateer.ec1.common.code.order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OPT0003 {
    ORDER("O"),
    CANCEL("C"),
    RETURN("R"),
    RETURN_CANCEL("RC"),
    EXCHANGE("X");

    private String type;

    public String getType() {
        return type;
    }
}
