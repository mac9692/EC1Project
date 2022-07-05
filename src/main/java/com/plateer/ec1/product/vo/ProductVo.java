package com.plateer.ec1.product.vo;

import com.plateer.ec1.common.code.promotion.PRM0004;
import com.plateer.ec1.common.code.promotion.PRM0010;
import com.plateer.ec1.promotion.vo.PromotionVo;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

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
    private String itemNo;
    private String itemNm;
    private Long prmNo;
    private Long cpnIssNo;
    private List<PromotionVo> promotionVoList;

    public Long validatePrmPrc() {
        if (prmPrc == null) {
            return salePrc;
        } else {
            return prmPrc;
        }
    }

    public void validatePromotionList() {
        promotionVoList = promotionVoList
                .parallelStream()
                .filter(PromotionVo::validateUseYn)
                .filter(PromotionVo::validateCouponUseDt)
                .filter(promotionVo -> promotionVo.getAplyTgtCcd().equals(PRM0010.PRODUCT.getType()))
                .filter(promotionVo -> promotionVo.getMdaGb().equals(""))
                .filter(promotionVo -> promotionVo.getEntChnGb().equals(""))
                .filter(PromotionVo::validateProductCoupon)
                .collect(Collectors.toList());

    }
}
