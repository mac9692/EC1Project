package com.plateer.ec1.promotion.controller;

import com.plateer.ec1.promotion.service.CouponService;
import com.plateer.ec1.promotion.vo.request.RequestCouponVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api")
@Slf4j
public class CouponController {

    private final CouponService couponService;

    @PostMapping(path = "downloadCoupon")
    public void downloadCoupon(RequestCouponVo requestCouponVo) {
        couponService.downloadCoupon(requestCouponVo);
    }

    @PostMapping(path = "useCoupon")
    public void useCoupon(RequestCouponVo requestCouponVo) {
        couponService.useCoupon(requestCouponVo);
    }

    @PostMapping(path = "cancelCoupon")
    public void cancelCoupon(RequestCouponVo requestCouponVo) {
        couponService.cancelCoupon(requestCouponVo);
    }
}
