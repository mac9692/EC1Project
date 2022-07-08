package com.plateer.ec1.promotion.processor.impl;

import com.plateer.ec1.product.vo.ProductVo;
import com.plateer.ec1.promotion.vo.CartCouponVo;
import com.plateer.ec1.promotion.vo.ProductCouponVo;
import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.mapper.PromotionMapper;
import com.plateer.ec1.promotion.processor.CalProcessor;
import com.plateer.ec1.promotion.vo.PromotionVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import com.plateer.ec1.promotion.vo.response.BaseResponseVo;
import com.plateer.ec1.promotion.vo.response.CartCouponResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class CartCouponCalProcessor implements CalProcessor {

    private final PromotionMapper promotionMapper;

    @Override
    public PromotionType getType() {
        return PromotionType.CART_COUPON;
    }

    public List<CartCouponVo> getAvailablePromotionData(RequestPromotionVo requestPromotionVo) {
        List<ProductVo> productVoList = requestPromotionVo.getProductVoList();
        List<PromotionVo> promotionVoList = promotionMapper.getPromotionInfo(requestPromotionVo);
        promotionVoList = promotionVoList.stream()
                .filter(PromotionVo::validateUseYn)
                .filter(PromotionVo::validateCouponUseDt)
                .filter(PromotionVo::validateCartCoupon)
                .collect(Collectors.toList());

        List<CartCouponVo> cartCouponVoList = new ArrayList<>();

        promotionVoList.forEach(promotionVo -> {
            CartCouponVo cartCouponVo = new CartCouponVo();
            cartCouponVo.setPromotionVo(promotionVo);
            cartCouponVo.setProductVoList(productVoList);
            cartCouponVoList.add(cartCouponVo);
        });

        return cartCouponVoList;
    }

    public List<CartCouponVo> calculateDcAmt(List<CartCouponVo> cartCouponVoList) {
        cartCouponVoList.forEach(CartCouponVo::calCartCouponDcAmt);
        return cartCouponVoList;
    }

    public List<CartCouponVo> calculateMaxBenefit(List<CartCouponVo> cartCouponVoList) {
        cartCouponVoList.stream()
                .sorted(Comparator.comparing(cartCouponVo -> cartCouponVo.getPromotionVo().getDcAmt()))
                .sorted(Comparator.comparing(cartCouponVo -> cartCouponVo.getPromotionVo().getPrmEndDt()))
                .sorted(Comparator.comparing(cartCouponVo -> cartCouponVo.getPromotionVo().getPrmNo()))
                .collect(Collectors.toList());
        cartCouponVoList.get(0).getPromotionVo().setMaxBenefitYn("Y");
        return cartCouponVoList;
    }

    @Override
    public BaseResponseVo getCalculationData(RequestPromotionVo requestPromotionVo) {
        List<CartCouponVo> cartCouponVoList =
                calculateMaxBenefit(calculateDcAmt(getAvailablePromotionData(requestPromotionVo)));
        CartCouponResponseVo cartCouponResponseVo = new CartCouponResponseVo();
        cartCouponResponseVo.setMemberNo(requestPromotionVo.getMbrNo());
        cartCouponResponseVo.setCartCouponVoList(cartCouponVoList);
        return cartCouponResponseVo;
    }
}
