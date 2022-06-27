package com.plateer.ec1.promotion.processor;

import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.vo.PromotionVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import com.plateer.ec1.promotion.vo.response.ResponseBaseVo;

public interface CalProcessor {

    PromotionType getType();

    PromotionVo getAvailablePromotionData(RequestPromotionVo requestPromotionVo);

    ResponseBaseVo calculateDcAmt(RequestPromotionVo requestPromotionVo, PromotionVo promotionVo);

    ResponseBaseVo calculateMaxBenefit(ResponseBaseVo responseBaseVo);

    ResponseBaseVo getCalculationData(RequestPromotionVo requestPromotionVo);

}
