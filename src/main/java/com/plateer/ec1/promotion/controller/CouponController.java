package com.plateer.ec1.promotion.controller;

import com.plateer.ec1.common.model.promotion.CcCpnBase;
import com.plateer.ec1.promotion.service.CouponService;
import com.plateer.ec1.promotion.vo.PromotionVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api")
@Slf4j
public class CouponController {

    private final CouponService couponService;

    @RequestMapping(path = "getDownloadCouponList")
    public List<CcCpnBase> getDownloadCouponList() {
        return couponService.getDownloadCouponList();
    }

    @PostMapping(path = "downloadCoupon")
    public PromotionVo downloadCoupon(RequestPromotionVo requestPromotionVo) {
        log.info("쿠폰 다운로드 시작");
        return couponService.downloadCoupon(requestPromotionVo);
    }

    @RequestMapping(path = "useCoupon")
    public Long useCoupon() {
        log.info("쿠폰 사용 시작");
        return couponService.useCoupon();
    }

    @RequestMapping(path = "cancelCoupon")
    public Long cancelCoupon() {
        log.info("쿠폰 사용 취소 시작");
        return couponService.cancelCoupon();
    }

    @RequestMapping(path = "verifyCoupon")
    public boolean verifyCoupon() {
        log.info("쿠폰 검증");
        return couponService.verifyCoupon();
    }
}
