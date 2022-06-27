package com.plateer.ec1.common.model.member;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class EtMbrBase {
    private String mbrNo;
    private String mbrId;
    private String mbrNm;
    private Timestamp sysRegDtime;
    private Timestamp sysModDtime;
    private String sysRegrId;
    private String sysModrId;
}
