package com.plateer.ec1.promotion.controller;

import com.plateer.ec1.common.model.promotion.CcCpnBase;
import com.plateer.ec1.common.model.promotion.CcPrmBase;
import com.plateer.ec1.promotion.service.CouponService;
import com.plateer.ec1.promotion.vo.PromotionVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping(path = "downloadCoupon")
    public void downloadCoupon(RequestPromotionVo requestPromotionVo) {
        log.info("쿠폰 다운로드 시작");
        couponService.downloadCoupon(requestPromotionVo);
    }

    @PostMapping(path = "useCoupon")
    public Long useCoupon(RequestPromotionVo requestPromotionVo) {
        log.info("쿠폰 사용 시작");
        return couponService.useCoupon(requestPromotionVo);
    }

    @PostMapping(path = "cancelCoupon")
    public Long cancelCoupon() {
        log.info("쿠폰 사용 취소 시작");
        return couponService.cancelCoupon();
    }

    @PostMapping(path = "verifyCoupon")
    public boolean verifyCoupon() {
        log.info("쿠폰 검증");
        return couponService.verifyCoupon();
    }
}
