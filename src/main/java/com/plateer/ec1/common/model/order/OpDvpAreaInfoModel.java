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

    public OpDvpAreaInfoModel generalOrder() {
        setDvpSeq();
        setRmtiNm();
        setRmtiHpNo();
        setRmtiAddr();
        setRmtiAddrDtl();
        return this;
    }

    public OpDvpAreaInfoModel mobileCouponOrder() {
        setDvpSeq();
        setRmtiNm();
        setRmtiHpNo();
        return this;
    }
}
