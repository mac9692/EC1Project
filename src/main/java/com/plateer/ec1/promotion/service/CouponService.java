package com.plateer.ec1.promotion.service;

import com.plateer.ec1.common.model.promotion.CcCpnBase;
import com.plateer.ec1.common.model.promotion.CcPrmBase;
import com.plateer.ec1.promotion.vo.PromotionVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;

import java.util.List;

public interface CouponService {
    Boolean validateCoupon(RequestPromotionVo requestPromotionVo);
    void downloadCoupon(RequestPromotionVo requestPromotionVo);

    Long useCoupon(RequestPromotionVo requestPromotionVo);

    Long cancelCoupon();

    boolean verifyCoupon();
}
