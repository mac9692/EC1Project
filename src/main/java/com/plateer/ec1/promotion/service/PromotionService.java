package com.plateer.ec1.promotion.service;

import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import com.plateer.ec1.promotion.vo.response.BaseResponseVo;

public interface PromotionService {

    public BaseResponseVo getPriceDiscountData(RequestPromotionVo requestPromotionVo);

    public BaseResponseVo getProductCouponDiscountData(RequestPromotionVo requestPromotionVo);

    public BaseResponseVo getCartCouponDiscountData(RequestPromotionVo requestPromotionVo);
}
