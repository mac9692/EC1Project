package com.plateer.ec1.promotion.processor.impl;

import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.mapper.PromotionMapper;
import com.plateer.ec1.promotion.processor.CalProcessor;
import com.plateer.ec1.promotion.vo.CartCouponVo;
import com.plateer.ec1.promotion.vo.ProductCouponVo;
import com.plateer.ec1.promotion.vo.PromotionVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import com.plateer.ec1.promotion.vo.response.ResponseBaseVo;
import com.plateer.ec1.promotion.vo.response.ResponseProductCouponVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProductCouponCalProcessor implements CalProcessor {

    private final PromotionMapper promotionMapper;

    @Override
    public PromotionType getType() {
        return PromotionType.PRODUCT_COUPON;
    }

    /*
    * 회원별 적용 가능 쿠폰 조회
    * 1. 프로모션 사용여부 검증
    * 2. 쿠폰 사용일자 검증(쿠폰 사용여부 검증)
    * 3. 적용 대상 구분 코드 검증 : 상품
    * 4. 매체 구분 일치 여부 검증
    * 5. 채널 일치 여부 검증
    * 6. 쿠폰 종류 코드 검증 : 상품
    * */
    @Override
    public PromotionVo getAvailablePromotionData(RequestPromotionVo requestPromotionVo) {
        log.info("[상품 쿠폰] 회원별 적용 가능 쿠폰 조회 서비스 시작");
        List<ProductCouponVo> productCouponVoList = promotionMapper.getCartCouponInfo(requestPromotionVo);
        productCouponVoList.stream()
                .filter(c -> c.getUseYn().toString().equals("Y"))
                .filter(c -> c.getCpnUseDt() == null)
                .filter(c -> c.getAplyTgtCcd().toString().equals("10"))
                .filter(c -> c.getMdaGb().toString().equals(""))
                .filter(c -> c.getEntChnGb().toString().equals(""))
                .filter(c -> c.getCpnKindCd().toString().equals("10"))
                .forEach(System.out::println);
        PromotionVo promotionVo = new PromotionVo();
        return promotionVo;
    }

    @Override
    public ResponseProductCouponVo calculateDcAmt(RequestPromotionVo requestPromotionVo, PromotionVo promotionVo) {
        log.info("[상품 쿠폰] 할인 금액 계산 서비스 시작");
        log.info("기 적용된 가격조정 확인");
        log.info("확인 성공 시 : 가격조정 금액 리턴");
        log.info("확인 실패 시 : 상품가격 리턴");
        log.info("쿠폰 할인금액 계산");
        log.info("하위 차수 쿠폰 여부 확인");
        log.info("확인되면 한번 더 쿠폰 할인금액 계산 반복");
        log.info("확인되지 않으면 계산 값 전달");
        log.info("[상품 쿠폰] 할인 금액 계산 서비스 시작");
        ResponseProductCouponVo responseProductCouponVo = new ResponseProductCouponVo();
        return responseProductCouponVo;
    }

    @Override
    public ResponseProductCouponVo calculateMaxBenefit(ResponseBaseVo responseBaseVo) {
        log.info("[상품 쿠폰] 최대 할인 혜택 적용 서비스 시작");
        ResponseProductCouponVo responseProductCouponVo = new ResponseProductCouponVo();
        log.info("[상품 쿠폰] 최대 할인 혜택 적용 서비스 종료");
        return responseProductCouponVo;
    }
    @Override
    public ResponseProductCouponVo getCalculationData(RequestPromotionVo requestPromotionVo) {
        log.info("[상품 쿠폰 계산 시작]");
        ResponseProductCouponVo responseProductCouponVo = calculateMaxBenefit(calculateDcAmt(requestPromotionVo, getAvailablePromotionData(requestPromotionVo)));
        log.info("[상품 쿠폰 계산 종료]");
        return responseProductCouponVo;
    }
}
