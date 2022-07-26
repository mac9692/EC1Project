package com.plateer.ec1.product.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@Builder
public class ProductVo {
    @NotNull(message = "상품번호는 필수값입니다.")
    private String goodsNo;
    private String goodsNm;
    private String goodsTpCd;
    private Long salePrc;
    private Long prmPrc;
    private String prgsStatCd;
    private String goodsDlvTpCd;
    private String itemNo;
    private String itemNm;
    private Long prmNo;
    private String aplyTgtSeq;
    private String aplyTgtCcd;
    private String aplyTgtNo;
    private String useYn;
    private Long cpnIssNo;
    private Long orderCount;
    private Long orderPrice;

    public Long validatePrmPrc() {
        if (prmPrc == null) {
            return salePrc;
        } else {
            return prmPrc;
        }
    }
}
