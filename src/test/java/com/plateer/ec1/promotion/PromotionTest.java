package com.plateer.ec1.promotion;

import com.plateer.ec1.promotion.controller.CouponController;
import com.plateer.ec1.promotion.controller.PointController;
import com.plateer.ec1.promotion.controller.PromotionController;
import com.plateer.ec1.promotion.service.CouponService;
import com.plateer.ec1.promotion.service.PromotionService;
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

    @Autowired
    CouponService couponService;

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
        requestPromotionVo.setMbrNo("test01");
        requestPromotionVo.setPrmNo(10L);
        requestPromotionVo.setGoodsNo("P001");
        requestPromotionVo.setItemNo("1");
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
        RequestPromotionVo requestPromotionVo = new RequestPromotionVo();
        requestPromotionVo.setPrmNo(2L);
        requestPromotionVo.setMbrNo("test01");
        couponController.downloadCoupon(requestPromotionVo);
    }

    @Test
    @DisplayName("4-2. 쿠폰 다운로드 테스트 - 실패 케이스 : 총 다운로드 가능 횟수 초과")
    void downloadCouponTest2() {
        RequestPromotionVo requestPromotionVo = new RequestPromotionVo();
        requestPromotionVo.setPrmNo(6L);
        requestPromotionVo.setMbrNo("test01");
        couponController.downloadCoupon(requestPromotionVo);
    }

    @Test
    @DisplayName("4-3. 쿠폰 사용 테스트")
    void useCouponTest() {
        RequestPromotionVo requestPromotionVo = new RequestPromotionVo();
        requestPromotionVo.setPrmNo(2L);
        requestPromotionVo.setMbrNo("test01");
        requestPromotionVo.setCpnIssNo(11L);
        requestPromotionVo.setOrdNo("2020");
        couponController.useCoupon(requestPromotionVo);
    }

    @Test
    @DisplayName("4-4. 쿠폰 취소 테스트")
    void cancelCouponTest() {
        RequestPromotionVo requestPromotionVo = new RequestPromotionVo();
        requestPromotionVo.setPrmNo(1L);
        requestPromotionVo.setMbrNo("test01");
        requestPromotionVo.setCpnIssNo(13L);
        requestPromotionVo.setOrdNo("213");
        couponController.cancelCoupon(requestPromotionVo);
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
