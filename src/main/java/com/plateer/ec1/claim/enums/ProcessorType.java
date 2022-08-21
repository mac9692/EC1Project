package com.plateer.ec1.claim.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ProcessorType {
    ACCEPT_WITHDRAWAL("10"),
    COMPLETE("20");

    private String type;

    public String getType() {
        return type;
    }
}
