package com.plateer.ec1.common.model.promotion;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CcMbrPntModel {

    private Long pntHstSeq;
    private String mbrNo;
    private String svUseCcd;
    private Integer svUseAmt;
    private Integer pntBlc;
    private String ordNo;
    private String payNo;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;
}
