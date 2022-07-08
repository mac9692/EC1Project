package com.plateer.ec1.promotion.processor.impl;

import com.plateer.ec1.product.vo.ProductVo;
import com.plateer.ec1.promotion.vo.ProductCouponVo;
import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.mapper.PromotionMapper;
import com.plateer.ec1.promotion.processor.CalProcessor;
import com.plateer.ec1.promotion.vo.PromotionVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import com.plateer.ec1.promotion.vo.response.BaseResponseVo;
import com.plateer.ec1.promotion.vo.response.ProductCouponResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProductCouponCalProcessor implements CalProcessor {

    private final PromotionMapper promotionMapper;

    @Override
    public PromotionType getType() {
        return PromotionType.PRODUCT_COUPON;
    }

    public List<ProductCouponVo> getAvailablePromotionData(RequestPromotionVo requestPromotionVo) {
        List<ProductVo> productVoList = requestPromotionVo.getProductVoList();
        List<PromotionVo> promotionVoList = promotionMapper.getPromotionInfo(requestPromotionVo);
        List<ProductCouponVo> productCouponVoList = new ArrayList<>();

        productVoList.forEach(productVo -> {
            ProductCouponVo productCouponVo = new ProductCouponVo();
            productCouponVo.setProductVo(productVo);
            productCouponVo.setPromotionVoList(promotionVoList);
            productCouponVoList.add(productCouponVo);
        });
        productCouponVoList.forEach(ProductCouponVo::validateProductCoupon);

        return productCouponVoList;
    }

    public List<ProductCouponVo> calculateDcAmt(List<ProductCouponVo> productCouponVoList) {
        productCouponVoList.forEach(ProductCouponVo::calProductCouponDcAmt);
        return productCouponVoList;
    }

    public List<ProductCouponVo> calculateMaxBenefit(List<ProductCouponVo> productCouponVoList) {
        productCouponVoList.forEach(ProductCouponVo::calculateMaxBenefit);
        return productCouponVoList;
    }

    @Override
    public BaseResponseVo getCalculationData(RequestPromotionVo requestPromotionVo) {
        List<ProductCouponVo> productCouponVoList =
                calculateMaxBenefit(calculateDcAmt(getAvailablePromotionData(requestPromotionVo)));
        ProductCouponResponseVo productCouponResponseVo = new ProductCouponResponseVo();
        productCouponResponseVo.setMemberNo(requestPromotionVo.getMbrNo());
        productCouponResponseVo.setProductCouponVoList(productCouponVoList);
        return productCouponResponseVo;
    }
}
