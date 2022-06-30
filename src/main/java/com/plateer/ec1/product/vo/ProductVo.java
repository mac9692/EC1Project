package com.plateer.ec1.product.vo;

import lombok.Data;

@Data
public class ProductVo {

    private String goodsNo;
    private String goodsNm;
    private String goodsTpCd;
    private Long salePrc;
    private Long prmPrc;
    private String prgsStatCd;
    private String goodsDlvTpCd;
    private String itemNo;
    private String itemNm;


    public Long validatePrmPrc() {
        if (prmPrc == null) {
            return salePrc;
        } else {
            return prmPrc;
        }
    }
}
