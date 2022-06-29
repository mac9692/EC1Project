package com.plateer.ec1.promotion.vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CartCouponVo {

    private Long prmNo;
    private String cpnKindCd;
    private String degrCcd;
    private Long cpnIssNo;
    private String mbrNo;
    private Timestamp cpnUseDt;

}
