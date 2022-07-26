package com.plateer.ec1.common.model.promotion;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CcCpnIssueModel {

    private Long cpnIssNo;
    private String mbrNo;
    private Timestamp cpnUseDt;
    private Long orgCpnIssNo;
    private String cpnCertNo;
    private String ordNo;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;
    private Long prmNo;
}
