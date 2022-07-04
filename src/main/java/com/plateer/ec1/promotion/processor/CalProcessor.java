package com.plateer.ec1.promotion.processor;

import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import com.plateer.ec1.promotion.vo.response.BaseResponseVo;

public interface CalProcessor {

    PromotionType getType();

    BaseResponseVo getCalculationData(RequestPromotionVo requestPromotionVo);

}
