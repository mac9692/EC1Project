package com.plateer.ec1.promotion.service;

import com.plateer.ec1.common.model.promotion.CcCpnBase;
import com.plateer.ec1.promotion.vo.PromotionVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;

import java.util.List;

public interface CouponService {

    List<CcCpnBase> getDownloadCouponList();

    boolean checkAvailableDownloadCoupon(String memberNo, PromotionVo promotionVo);

    PromotionVo downloadCoupon(RequestPromotionVo requestPromotionVo);

    Long useCoupon();

    Long cancelCoupon();

    boolean verifyCoupon();
}
