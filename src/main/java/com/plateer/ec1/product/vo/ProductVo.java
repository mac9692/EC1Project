package com.plateer.ec1.product.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProductVo {

    @NotNull(message = "상품번호는 필수값입니다.")
    private String goodsNo;
    private String goodsNm;
    private String goodsTpCd;
    private Long salePrc;
    private Long prmPrc;
    private String prgsStatCd;
    private String goodsDlvTpCd;

    @NotNull(message = "단품번호는 필수값입니다.")
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
