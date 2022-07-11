package com.plateer.ec1.promotion.service;

import com.plateer.ec1.promotion.vo.request.RequestCouponVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;

public interface CouponService {
    Boolean validateCoupon(RequestCouponVo requestCouponVo);
    void downloadCoupon(RequestCouponVo requestCouponVo);

    void useCoupon(RequestCouponVo requestCouponVo);

    void cancelCoupon(RequestCouponVo requestCouponVo);
}
