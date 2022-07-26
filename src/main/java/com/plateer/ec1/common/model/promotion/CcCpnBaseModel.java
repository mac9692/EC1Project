package com.plateer.ec1.common.model.promotion;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CcCpnBaseModel {

    private Long prmNo;
    private String cpnKindCd;
    private String degrCcd;
    private String dcSvCcd;
    private String mdaGb;
    private String entChnGb;
    private String dwlPriodCcd;
    private String dwlAvlStrtDd;
    private String dwlAvlEndDd;
    private Long dwlStdDd;
    private Long dwlPsbCnt;
    private Long psnDwlPsbCnt;
    private String dwlAvlPlc;
    private String issWayCcd;
    private String certCd;
    private Integer ourChrgRt;
    private Integer entrChrgRt;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;
}
