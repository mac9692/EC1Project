package com.plateer.ec1.common.model.order;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OpOrdBase {

    private String ordNo;
    private String mbrNo;
    private String ordTpCd;
    private String ordSysCcd;
    private Timestamp ordReqDtime;
    private Timestamp ordCmtDtime;
    private String ordNm;
    private String ordSellNo;
    private String ordAddr;
    private String ordAddrDtl;
    private String rfndBnkCk;
    private String rfndAcctNo;
    private String rfndAcctOwnNm;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModrId;
    private String sysModDtim;
}
