package com.plateer.ec1.payment.vo;

import lombok.Data;

@Data
public class OrderBaseVo {

    private String payNo;
    private String ordNo;
    private String clmNo;
    private String payMnCd;
    private String payCcd;
    private String payPrgsScd;
    private Long payAmt;
    private Long cnclAmt;
    private Long rfndAvlAmt;
    private String trsnId;
    private String orgPayNo;
    private String vrAcct;
    private String vrAcctNm;
    private String vrBnkCd;

    private String rfndBnkCk;
    private String rfndAcctNo;
    private String rfndAcctOwnNm;

}
