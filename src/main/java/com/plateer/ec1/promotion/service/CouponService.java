package com.plateer.ec1.promotion.service;

import com.plateer.ec1.promotion.vo.Promotion;

import java.util.List;

public interface CouponService {

    List<Promotion> getDownloadCouponList(String memberNo);

    boolean checkAvailableDownloadCoupon(String memberNo, Promotion promotion);

    Promotion downloadCoupon(String memberNo, Promotion promotion);

    Long useCoupon();

    Long cancelCoupon();

    boolean verifyCoupon();
}
