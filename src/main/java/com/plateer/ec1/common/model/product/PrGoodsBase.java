package com.plateer.ec1.common.model.product;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PrGoodsBase {

    private String goodsNm;
    private String goodsTpCd;
    private Long salePrc;
    private Long prmPrc;
    private String prgsStatCd;
    private Timestamp sysRegDtime;
    private Timestamp sysModDtime;
    private String sysRegrId;
    private String sysModrId;
    private String goodsDlvTpCd;
    private String goodsNo;
}
