package com.plateer.ec1.payment.vo;

import lombok.Data;

import java.sql.Timestamp;

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
    private Timestamp payCmtDtime;
    private String orgPayNo;
    private String vrAcct;
    private String vrAcctNm;
    private String vrBnkCd;
    private String vrValDt;
    private String vrValTt;
    private String rfndBnkCk;
    private String rfndAcctNo;
    private String rfndAcctOwnNm;

}
