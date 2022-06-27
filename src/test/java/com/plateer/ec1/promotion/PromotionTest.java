package com.plateer.ec1.promotion;

import com.plateer.ec1.promotion.controller.CouponController;
import com.plateer.ec1.promotion.controller.PointController;
import com.plateer.ec1.promotion.controller.PromotionController;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
@TestMethodOrder(value = MethodOrderer.DisplayName.class)
public class PromotionTest {

    @Autowired
    PromotionController promotionController;

    @Autowired
    CouponController couponController;

    @Autowired
    PointController pointController;

    @Test
    @DisplayName("1. 가격할인금액 계산 테스트")
    void priceDiscountCalculationTest() {
        log.info("1. 가격할인금액 계산 테스트 시작");
        RequestPromotionVo requestPromotionVo = new RequestPromotionVo();
        promotionController.getPriceDiscountApplyData(requestPromotionVo);
        log.info("1. 가격할인금액 계산 테스트 종료");
    }

    @Test
    @DisplayName("2. 상품쿠폰할인 계산 테스트")
    void productCouponCalculationTest() {
        log.info("2. 상품쿠폰할인 계산 테스트 시작");
        RequestPromotionVo requestPromotionVo = new RequestPromotionVo();
        promotionController.getProductCouponApplyData(requestPromotionVo);
        log.info("2. 상품쿠폰할인 계산 테스트 종료");
    }

    @Test
    @DisplayName("3. 장바구니쿠폰할인 계산 테스트")
    void cartCouponCalculationTest() {
        log.info("3. 장바구니쿠폰할인 계산 테스트 시작");
        RequestPromotionVo requestPromotionVo = new RequestPromotionVo();
        promotionController.getCartCouponApplyData(requestPromotionVo);
        log.info("3. 장바구니쿠폰할인 계산 테스트 종료");
    }

    @Test
    @DisplayName("4-1. 쿠폰 다운로드 테스트 - 성공 케이스")
    void downloadCouponTest() {
        log.info("4-1. 쿠폰 다운로드 테스트 시작");
        RequestPromotionVo requestPromotionVo = new RequestPromotionVo();
        requestPromotionVo.setPrmNo(1L);
        requestPromotionVo.setMbrNo("test01");
        couponController.downloadCoupon(requestPromotionVo);
        log.info("4-1. 쿠폰 다운로드 테스트 종료");
    }

    @Test
    @DisplayName("4-2. 쿠폰 다운로드 테스트 - 실패 케이스 : 다운로드 가능 횟수 초과")
    void downloadCouponTest2() {
        log.info("4-2. 쿠폰 다운로드 테스트 시작");
        RequestPromotionVo requestPromotionVo = new RequestPromotionVo();
        requestPromotionVo.setPrmNo(5L);
        requestPromotionVo.setMbrNo("test01");
        couponController.downloadCoupon(requestPromotionVo);
        log.info("4-2. 쿠폰 다운로드 테스트 종료");
    }

    @Test
    @DisplayName("5. 포인트 정보 조회 테스트")
    void getPointInfoTest() {
        log.info("5. 포인트 정보 조회 테스트 시작");
        RequestPromotionVo requestPromotionVo = new RequestPromotionVo();
        pointController.getPointInfo(requestPromotionVo);
        log.info("5. 포인트 정보 조회 테스트 종료");
    }

}
