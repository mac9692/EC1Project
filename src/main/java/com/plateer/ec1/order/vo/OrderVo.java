package com.plateer.ec1.order.vo;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderVo {
    private String ordNo;
    private String mbrNo;
    private String ordTpCd;
    private String ordSysCcd;
    private String ordNm;
    private String ordSellNo;
    private String ordAddr;
    private String ordAddrDtl;
}
