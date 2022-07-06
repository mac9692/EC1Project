package com.plateer.ec1.promotion.processor.impl;

import com.plateer.ec1.common.code.promotion.PRM0003;
import com.plateer.ec1.common.code.promotion.PRM0004;
import com.plateer.ec1.common.code.promotion.PRM0010;
import com.plateer.ec1.product.vo.ProductVo;
import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.mapper.PromotionMapper;
import com.plateer.ec1.promotion.processor.CalProcessor;
import com.plateer.ec1.promotion.vo.ProductCouponVo;
import com.plateer.ec1.promotion.vo.PromotionVo;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import com.plateer.ec1.promotion.vo.response.ProductCouponResponseVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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

    /*
    * 회원별 적용 가능 쿠폰 조회
    * 1. 프로모션 사용여부 검증
    * 2. 쿠폰 사용일자 검증(쿠폰 사용여부 검증)
    * 3. 프로모션 기간 유효성 검증
    * 4. 적용 대상 구분 코드 검증 : 상품
    * 5. 매체 구분 일치 여부 검증
    * 6. 채널 일치 여부 검증
    * 7. 쿠폰 종류 코드 검증 : 상품
    * */
    public List<ProductVo> getAvailablePromotionData(RequestPromotionVo requestPromotionVo) {
        List<ProductVo> productVoList = requestPromotionVo.getProductVoList();
        requestPromotionVo.getProductVoList()
                .parallelStream()
                .forEach(c -> c.setPromotionVoList(promotionMapper.getCartCouponInfo(requestPromotionVo)));
        productVoList.forEach(ProductVo::validatePromotionList);
        return productVoList;
    }

    public List<ProductVo> calculateDcAmt(List<ProductVo> productVoList) {
        productVoList
                .parallelStream()
                .forEach(ProductVo::calCartCouponDcAmt);
        return productVoList;
    }

    public List<ProductVo> calculateMaxBenefit(List<ProductVo> productVoList) {
        System.out.println(productVoList);
        productVoList
                .parallelStream()
                .forEach(ProductVo::calculateMaxBenefit);
        return productVoList;
    }

    @Override
    public ProductCouponResponseVo getCalculationData(RequestPromotionVo requestPromotionVo) {
        List<ProductVo> productVoList =
                calculateMaxBenefit(calculateDcAmt(getAvailablePromotionData(requestPromotionVo)));
        ProductCouponResponseVo productCouponResponseVo = new ProductCouponResponseVo();
        productCouponResponseVo.setMemberNo(requestPromotionVo.getMbrNo());
        productCouponResponseVo.setProductVoList(productVoList);
        return productCouponResponseVo;
    }
}
