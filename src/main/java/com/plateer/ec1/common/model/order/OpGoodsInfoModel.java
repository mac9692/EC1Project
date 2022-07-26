package com.plateer.ec1.common.model.order;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OpGoodsInfoModel {
    private String ordNo;
    private String ordGoodsNo;
    private String ordItemNo;
    private String goodsSellTpCd;
    private String goodsDlvTpCd;
    private String goodsNm;
    private String itemNm;
    private Long sellAmt;
    private Long sellDcAmt;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;
}
