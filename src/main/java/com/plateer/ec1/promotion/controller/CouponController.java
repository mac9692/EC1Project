package com.plateer.ec1.promotion.controller;

import com.plateer.ec1.promotion.service.CouponService;
import com.plateer.ec1.promotion.vo.Promotion;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public List<Promotion> getDownloadCouponList(RequestPromotionVo requestPromotionVo) {
        log.info("다운로드 가능한 쿠폰 리스트 조회 시작");
        return couponService.getDownloadCouponList(requestPromotionVo.getMemberNo());
    }

    @RequestMapping(path = "checkAvailableDownloadCoupon")
    public boolean checkAvailableDownloadCoupon(RequestPromotionVo requestPromotionVo) {
        log.info("다운로드 가능한 쿠폰 체크 시작");
        return couponService.checkAvailableDownloadCoupon(requestPromotionVo.getMemberNo(), requestPromotionVo.getPromotion());
    }

    @RequestMapping("downloadCoupon")
    public Promotion downloadCoupon(RequestPromotionVo requestPromotionVo) {
        log.info("쿠폰 다운로드 시작");
        return couponService.downloadCoupon(requestPromotionVo.getMemberNo(), requestPromotionVo.getPromotion());
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
