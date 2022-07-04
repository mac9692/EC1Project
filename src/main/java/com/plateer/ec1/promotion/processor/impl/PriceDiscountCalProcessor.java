package com.plateer.ec1.promotion.processor.impl;

import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.processor.CalProcessor;
import com.plateer.ec1.promotion.vo.ProductCouponVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import com.plateer.ec1.promotion.vo.response.BaseResponseVo;
import com.plateer.ec1.promotion.vo.response.PriceDcResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class PriceDiscountCalProcessor implements CalProcessor {

    @Override
    public PromotionType getType() {
        return PromotionType.PRICE_DISCOUNT;
    }

    public List<ProductCouponVo> getAvailablePromotionData(RequestPromotionVo requestPromotionVo) {
        log.info("[가격 할인 적용] 회원별 적용 가능한 프로모션 조회");
        return null;
    }

    public PriceDcResponseVo calculateDcAmt(RequestPromotionVo requestPromotionVo, List<ProductCouponVo> productCouponVoList) {
        log.info("[가격 할인 적용] 할인 금액 계산");
        return null;
    }

    public PriceDcResponseVo calculateMaxBenefit(BaseResponseVo baseResponseVo) {
        log.info("[가격 할인 적용] 최대 할인 혜택 적용");
        return null;
    }

    @Override
    public PriceDcResponseVo getCalculationData(RequestPromotionVo requestPromotionVo) {
        log.info("[가격 할인 적용 계산 시작]");
        calculateDcAmt(requestPromotionVo, null);
        calculateMaxBenefit(null);
        PriceDcResponseVo responsePriceDcVo = new PriceDcResponseVo();
//        responsePriceDcVo.setMemberNo(requestPromotionVo.getMemberNo());
//        responsePriceDcVo.setProductList(requestPromotionVo.getProductList());
        log.info(String.valueOf(responsePriceDcVo));
        return responsePriceDcVo;
    }
}
