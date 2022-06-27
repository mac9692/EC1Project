package com.plateer.ec1.common.model.promotion;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CcPrmExclTgt {

    private Long exclTgtSeq;
    private String exclTgtCcd;
    private String exclTgtNo;
    private String useYn;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;
    private Long prmNo;
}
