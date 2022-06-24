package com.plateer.ec1.promotion.service;

import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import com.plateer.ec1.promotion.vo.response.ResponseBaseVo;

public interface PromotionService {

    public ResponseBaseVo getPriceDiscountData(RequestPromotionVo requestPromotionVo);

    public ResponseBaseVo getProductCouponDiscountData(RequestPromotionVo requestPromotionVo);

    public ResponseBaseVo getCartCouponDiscountData(RequestPromotionVo requestPromotionVo);
}
