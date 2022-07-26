package com.plateer.ec1.common.model.order;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OpOrdBnfRelInfoModel {

    private String ordNo;
    private Integer ordSeq;
    private Integer procSeq;
    private String ordBnfNo;
    private String aplyCnclCcd;
    private Long aplyAmt;
    private String clmNo;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;
}
