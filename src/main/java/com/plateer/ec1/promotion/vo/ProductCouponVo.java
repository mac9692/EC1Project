package com.plateer.ec1.promotion.vo;

import com.plateer.ec1.product.vo.ProductVo;
import com.plateer.ec1.promotion.vo.PromotionVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProductCouponVo {

    private ProductVo productVo;
    private List<PromotionVo> promotionVoList;


    public void validateCommonPromotionList() {
        promotionVoList = promotionVoList
                .parallelStream()
                .filter(PromotionVo::validateUseYn)
                .filter(PromotionVo::validateCouponUseDt)
//                .filter(promotionVo -> promotionVo.getAplyTgtCcd().equals(PRM0010.PRODUCT.getType()))
//                .filter(promotionVo -> "".equals(promotionVo.getMdaGb()))
//                .filter(promotionVo -> "".equals(promotionVo.getEntChnGb()))
//                .filter(promotionVo -> promotionVo.validateMinPurAmt(validatePrmPrc()))
                .collect(Collectors.toList());
    }

    public void validateProductCoupon() {
        validateCommonPromotionList();
        promotionVoList = promotionVoList
                .parallelStream()
                .filter(PromotionVo::validateProductCoupon)
                .collect(Collectors.toList());
    }

    public void validateCartCoupon() {
        validateCommonPromotionList();
        promotionVoList = promotionVoList
                .parallelStream()
                .filter(PromotionVo::validateCartCoupon)
                .collect(Collectors.toList());
    }

    public void calProductCouponDcAmt() {
        promotionVoList = promotionVoList.parallelStream()
                .peek(promotionVo -> promotionVo.calculateDcAmt(productVo.validatePrmPrc())).collect(Collectors.toList());
    }

    public void calculateMaxBenefit() {
        promotionVoList = promotionVoList.parallelStream()
                .sorted(Comparator.comparing(PromotionVo::getDcAmt))
                .sorted(Comparator.comparing(PromotionVo::getPrmEndDt))
                .sorted(Comparator.comparing(PromotionVo::getPrmNo))
                .collect(Collectors.toList());
        promotionVoList.get(0).setMaxBenefitYn("Y");
    }
}
