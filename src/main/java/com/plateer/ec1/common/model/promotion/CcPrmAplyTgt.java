package com.plateer.ec1.common.model.promotion;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CcPrmAplyTgt {

    private Long aplyTgtSeq;
    private String aplyTgtCcd;
    private String aplyTgtNo;
    private String useYn;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;
    private Long prmNo;
}
