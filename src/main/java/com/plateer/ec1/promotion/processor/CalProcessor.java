package com.plateer.ec1.promotion.processor;

import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.vo.ProductCouponVo;
import com.plateer.ec1.promotion.vo.PromotionVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import com.plateer.ec1.promotion.vo.response.ResponseBaseVo;

import java.util.List;

public interface CalProcessor {

    PromotionType getType();

    List<ProductCouponVo> getAvailablePromotionData(RequestPromotionVo requestPromotionVo);

    ResponseBaseVo calculateDcAmt(RequestPromotionVo requestPromotionVo, List<ProductCouponVo> productCouponVoList);

    ResponseBaseVo calculateMaxBenefit(ResponseBaseVo responseBaseVo);

    ResponseBaseVo getCalculationData(RequestPromotionVo requestPromotionVo);

}
