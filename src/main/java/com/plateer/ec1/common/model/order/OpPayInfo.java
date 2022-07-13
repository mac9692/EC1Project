package com.plateer.ec1.common.model.order;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class OpPayInfo {

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
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;
    private String orgPayNo;
    private String vrAcct;
    private String vrAcctNm;
    private String vrBnkCd;
    private String vrValDt;
    private String vrValTt;
}
