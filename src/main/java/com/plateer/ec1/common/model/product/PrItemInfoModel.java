package com.plateer.ec1.common.model.product;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PrItemInfoModel {

    private String goodsNo;
    private String itemNo;
    private String itemNm;
    private Timestamp sysRegDtime;
    private Timestamp sysModDtime;
    private String sysRegrId;
    private String sysModrId;
}
