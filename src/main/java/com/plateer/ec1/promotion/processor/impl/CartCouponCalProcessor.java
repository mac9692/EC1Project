package com.plateer.ec1.promotion.processor.impl;

import com.plateer.ec1.product.vo.ProductVo;
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

    public List<ProductVo> getAvailablePromotionData(RequestPromotionVo requestPromotionVo) {
        List<ProductVo> productVoList = requestPromotionVo.getProductVoList();
        requestPromotionVo.getProductVoList()
                .parallelStream()
                .forEach(productVo -> productVo.setPromotionVoList(promotionMapper.getCouponInfo(requestPromotionVo)));
        productVoList.forEach(ProductVo::validateCartCoupon);
        return productVoList;
    }

    public CartCouponResponseVo calculateDcAmt(List<ProductVo> productVoList) {
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
        CartCouponResponseVo responseCartCouponVo = calculateMaxBenefit(calculateDcAmt(getAvailablePromotionData(requestPromotionVo)));
        log.info("[장바구니 쿠폰 계산 종료]");
        return null;
    }
}
