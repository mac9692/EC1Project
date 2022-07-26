package com.plateer.ec1.common.model.order;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OpOrdBnfInfoModel {

    private String ordBnfNo;
    private Integer ordBnfAmt;
    private Long prmNo;
    private Long cpnIssNo;
    private Integer ordCnclBnfAmt;
    private Integer degrCcd;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;
    private String cpnKndCd;
}
