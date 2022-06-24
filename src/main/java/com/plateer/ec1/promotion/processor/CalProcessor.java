package com.plateer.ec1.promotion.processor;

import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.vo.Promotion;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import com.plateer.ec1.promotion.vo.response.ResponseBaseVo;

public interface CalProcessor {

    PromotionType getType();

    Promotion getAvailablePromotionData(RequestPromotionVo requestPromotionVo);

    ResponseBaseVo calculateDcAmt(RequestPromotionVo requestPromotionVo, Promotion promotion);

    ResponseBaseVo calculateMaxBenefit(ResponseBaseVo responseBaseVo);

    ResponseBaseVo getCalculationData(RequestPromotionVo requestPromotionVo);

}
