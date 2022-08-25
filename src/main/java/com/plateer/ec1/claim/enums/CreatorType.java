package com.plateer.ec1.claim.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CreatorType {

    GENERALORDERCANCEL("10"),
    ECOUPONCANCELACCEPT("20"),
    ECOUPONCANCELCOMPLETE("30"),
    EXCHANGEACCEPT("40"),
    EXCHANGEWITHDRAWAL("50"),
    RETURNACCEPT("60"),
    RETURNWITHDRAWAL("70");

    /*
    일반상품주문취소완료,
    E쿠폰주문취소접수,
    E쿠폰주문취소완료,
    교환접수,
    교환접수철회,
    반품접수,
    반품철회;
    */

    private String type;

    public String getType() {
        return type;
    }
}
