package com.plateer.ec1.claim.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CreatorType {
    ECOUPONCANCELACCEPT("10"),
    ECOUPONCANCELCOMPLETE("20"),
    EXCHANGEACCEPT("30"),
    EXCHANGEWITHDRAWAL("40"),
    GENERALORDERCANCEL("50"),
    RETURNACCEPT("60"),
    RETURNWITHDRAWAL("70");

    /*
    E쿠폰주문취소접수,
    E쿠폰취소완료,
    교환접수,
    교환접수철회,
    일반상품주문취소완료,
    반품접수,
    반품철회;
    */

    private String type;

    public String getType() {
        return type;
    }
}
