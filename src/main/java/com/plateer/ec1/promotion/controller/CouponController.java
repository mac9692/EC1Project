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

    @GetMapping(path = "getDownloadCouponList")
    public List<CcPrmBase> getDownloadCouponList(RequestPromotionVo requestPromotionVo) {
        log.info("다운로드 가능 쿠폰 조회 시작");
        requestPromotionVo.setMbrNo("test01");
        requestPromotionVo.setPrmNo(1L);
        return couponService.getDownloadCouponList(requestPromotionVo);
    }

    @GetMapping(path = "checkAvailableDownloadCoupon")
    public Integer checkAvailableDownloadCoupon(RequestPromotionVo requestPromotionVo) {
        requestPromotionVo.setMbrNo("test01");
        requestPromotionVo.setPrmNo(1L);
        return couponService.checkAvailableDownloadCoupon(requestPromotionVo);
    }

    @PostMapping(path = "downloadCoupon")
    public List<CcPrmBase> downloadCoupon(RequestPromotionVo requestPromotionVo) {
        log.info("쿠폰 다운로드 시작");
        return couponService.downloadCoupon(requestPromotionVo);
    }

    @PostMapping(path = "useCoupon")
    public Long useCoupon() {
        log.info("쿠폰 사용 시작");
        return couponService.useCoupon();
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
