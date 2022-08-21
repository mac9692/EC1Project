package com.plateer.ec1.common.code.order;

import lombok.AllArgsConstructor;

/**
 * 주문진행상태코드
 * 주문완료
 * 취소요청
 * 취소완료
 * 배송완료
 * 반품접수
 * 주문대기
 * 반품철회완
 */
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
    private final String type;

    public String getType() {
        return type;
    }
}
