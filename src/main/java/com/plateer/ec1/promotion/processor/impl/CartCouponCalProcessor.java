package com.plateer.ec1.promotion.processor.impl;

import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.mapper.PromotionMapper;
import com.plateer.ec1.promotion.processor.CalProcessor;
import com.plateer.ec1.promotion.vo.ProductCouponVo;
import com.plateer.ec1.promotion.vo.PromotionVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import com.plateer.ec1.promotion.vo.response.BaseResponseVo;
import com.plateer.ec1.promotion.vo.response.CartCouponResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class CartCouponCalProcessor implements CalProcessor {

    private final PromotionMapper promotionMapper;

    @Override
    public PromotionType getType() {
        return PromotionType.CART_COUPON;
    }

    public List<ProductCouponVo> getAvailablePromotionData(RequestPromotionVo requestPromotionVo) {
        log.info("[장바구니 쿠폰] 회원별 적용 가능한 쿠폰 조회 서비스 시작");
        log.info("쿠폰 적용 대상 여부 검증");
        log.info("매체 구분 일치 여부 검증");
        log.info("채널 일치 여부 검증");
        log.info("하나라도 검증 실패 시 : 종료");
        log.info("혜택 구분 = 할인?");
        log.info("할인이 아니면 포인트 적립");
        log.info("[장바구니 쿠폰] 회원별 적용 가능한 쿠폰 조회 서비스 종료");
        PromotionVo promotionVo = new PromotionVo();
        return null;
    }

    public CartCouponResponseVo calculateDcAmt(RequestPromotionVo requestPromotionVo, List<ProductCouponVo> productCouponVoList) {
        log.info("[장바구니 쿠폰] 할인 금액 계산 서비스 시작");
        log.info("기 적용된 가격조정 확인");
        log.info("확인 성공 시 : 가격조정 금액 리턴");
        log.info("확인 실패 시 : 상품가격 리턴");
        log.info("쿠폰 할인금액 계산");
        log.info("하위 차수 쿠폰 여부 확인");
        log.info("확인되면 한번 더 쿠폰 할인금액 계산 반복");
        log.info("확인되지 않으면 계산 값 전달");
        log.info("[장바구니 쿠폰] 할인 금액 계산 서비스 종료");
        CartCouponResponseVo responseCartCouponVo = new CartCouponResponseVo();
        return responseCartCouponVo;
    }

    public CartCouponResponseVo calculateMaxBenefit(BaseResponseVo baseResponseVo) {
        log.info("[장바구니 쿠폰] 최대 할인 혜택 적용 서비스 시작");
        CartCouponResponseVo responseCartCouponVo = new CartCouponResponseVo();
        log.info("[장바구니 쿠폰] 최대 할인 혜택 적용 서비스 종료");
        return responseCartCouponVo;
    }

    @Override
    public CartCouponResponseVo getCalculationData(RequestPromotionVo requestPromotionVo) {
        log.info("[장바구니 쿠폰 계산 시작]");
        CartCouponResponseVo responseCartCouponVo = calculateMaxBenefit(calculateDcAmt(requestPromotionVo, null));
        log.info("[장바구니 쿠폰 계산 종료]");
        return null;
    }
}
