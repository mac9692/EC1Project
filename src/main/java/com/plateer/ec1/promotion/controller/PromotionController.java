package com.plateer.ec1.promotion.controller;

import com.plateer.ec1.promotion.service.PromotionService;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import com.plateer.ec1.promotion.vo.response.BaseResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api")
@Slf4j
public class PromotionController {

    private final PromotionService promotionService;

    @GetMapping(value = "priceDiscount")
    public BaseResponseVo getPriceDiscountApplyData(RequestPromotionVo requestPromotionVo) {
        return promotionService.getPriceDiscountData(requestPromotionVo);
    }

    @GetMapping(value = "productCoupon")
    public BaseResponseVo getProductCouponApplyData(@Valid RequestPromotionVo requestPromotionVo) {
        return promotionService.getProductCouponDiscountData(requestPromotionVo);
    }

    @GetMapping(value = "cartCoupon")
    public BaseResponseVo getCartCouponApplyData(RequestPromotionVo requestPromotionVo) {
        return promotionService.getCartCouponDiscountData(requestPromotionVo);
    }

}
