package com.plateer.ec1.promotion.processor.impl;

import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.processor.CalProcessor;
import com.plateer.ec1.promotion.vo.PromotionVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import com.plateer.ec1.promotion.vo.response.ResponseBaseVo;
import com.plateer.ec1.promotion.vo.response.ResponsePriceDcVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PriceDiscountCalProcessor implements CalProcessor {

    @Override
    public PromotionType getType() {
        return PromotionType.PRICE_DISCOUNT;
    }

    @Override
    public PromotionVo getAvailablePromotionData(RequestPromotionVo requestPromotionVo) {
        log.info("[가격 할인 적용] 회원별 적용 가능한 프로모션 조회");
        return null;
    }

    @Override
    public ResponsePriceDcVo calculateDcAmt(RequestPromotionVo requestPromotionVo, PromotionVo promotionVo) {
        log.info("[가격 할인 적용] 할인 금액 계산");
        return null;
    }

    @Override
    public ResponsePriceDcVo calculateMaxBenefit(ResponseBaseVo responseBaseVo) {
        log.info("[가격 할인 적용] 최대 할인 혜택 적용");
        return null;
    }

    @Override
    public ResponsePriceDcVo getCalculationData(RequestPromotionVo requestPromotionVo) {
        log.info("[가격 할인 적용 계산 시작]");
        PromotionVo promotionVo = getAvailablePromotionData(requestPromotionVo);
        calculateDcAmt(requestPromotionVo, promotionVo);
        calculateMaxBenefit(null);
        ResponsePriceDcVo responsePriceDcVo = new ResponsePriceDcVo();
//        responsePriceDcVo.setMemberNo(requestPromotionVo.getMemberNo());
//        responsePriceDcVo.setProductList(requestPromotionVo.getProductList());
        log.info(String.valueOf(responsePriceDcVo));
        return responsePriceDcVo;
    }
}
