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

    /*
     * 회원별 적용 가능 쿠폰 조회
     * 1. 프로모션 사용여부 검증
     * 2. 쿠폰 사용일자 검증(쿠폰 사용여부 검증)
     * 3. 프로모션 기간 유효성 검증
     * 4. 적용 대상 구분 코드 검증 : 상품
     * 5. 매체 구분 일치 여부 검증
     * 6. 채널 일치 여부 검증
     * 7. 쿠폰 종류 코드 검증 : 상품
     * */
    public void validateProductCoupon() {
        promotionVoList = promotionVoList
                .parallelStream()
                .filter(PromotionVo::validateUseYn)
                .filter(PromotionVo::validateCouponUseDt)
//                .filter(promotionVo -> promotionVo.getAplyTgtCcd().equals(PRM0010.PRODUCT.getType()))
//                .filter(promotionVo -> "".equals(promotionVo.getMdaGb()))
//                .filter(promotionVo -> "".equals(promotionVo.getEntChnGb()))
//                .filter(promotionVo -> promotionVo.validateMinPurAmt(validatePrmPrc()))
                .filter(PromotionVo::validateProductCoupon)
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
