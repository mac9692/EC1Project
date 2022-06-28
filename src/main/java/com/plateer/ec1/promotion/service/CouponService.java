package com.plateer.ec1.promotion.service;

import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;

public interface CouponService {
    Boolean validateCoupon(RequestPromotionVo requestPromotionVo);
    void downloadCoupon(RequestPromotionVo requestPromotionVo);

    void useCoupon(RequestPromotionVo requestPromotionVo);

    void cancelCoupon(RequestPromotionVo requestPromotionVo);
}
