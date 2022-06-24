package com.plateer.ec1.promotion.controller;

import com.plateer.ec1.promotion.service.PromotionService;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import com.plateer.ec1.promotion.vo.response.ResponseBaseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api")
@Slf4j
public class PromotionController {

    private final PromotionService promotionService;

    @RequestMapping(value = "priceDiscount")
    public ResponseBaseVo getPriceDiscountApplyData(RequestPromotionVo requestPromotionVo) {
        log.info("가격 할인 적용 시작");
        return promotionService.getPriceDiscountData(requestPromotionVo);
    }

    @RequestMapping(value = "productCoupon")
    public ResponseBaseVo getProductCouponApplyData(RequestPromotionVo requestPromotionVo) {
        log.info("상품쿠폰 적용 시작");
        return promotionService.getProductCouponDiscountData(requestPromotionVo);
    }
    @RequestMapping(value = "cartCoupon")
    public ResponseBaseVo getCartCouponApplyData(RequestPromotionVo requestPromotionVo) {
        log.info("장바구니 쿠폰 적용 시작");
        return promotionService.getCartCouponDiscountData(requestPromotionVo);
    }

}
