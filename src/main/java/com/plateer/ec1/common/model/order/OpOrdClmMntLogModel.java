package com.plateer.ec1.common.model.order;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OpOrdClmMntLogModel {
    private Integer logSeq;
    private String ordNo;
    private String clmNo;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;
    private String procCcd;
}
