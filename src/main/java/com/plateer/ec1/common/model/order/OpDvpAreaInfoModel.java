package com.plateer.ec1.common.model.order;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OpDvpAreaInfoModel {

    private String ordNo;
    private Integer dvpSeq;
    private String rmtiNm;
    private String rmtiHpNo;
    private String rmtiAddr;
    private String rmtiAddrDtl;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;
}
