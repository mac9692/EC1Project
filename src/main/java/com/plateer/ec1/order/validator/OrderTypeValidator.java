package com.plateer.ec1.order.validator;

import com.plateer.ec1.common.code.product.PRD0001;
import com.plateer.ec1.common.code.product.PRD0002;
import com.plateer.ec1.order.enums.DataStrategyType;
import com.plateer.ec1.order.mapper.OrderMapper;
import com.plateer.ec1.order.vo.OrderGoodsVo;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import com.plateer.ec1.product.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderTypeValidator implements Validator {

    private final OrderMapper orderMapper;

    @Override
    public boolean supports(Class<?> clazz) {
        return RequestOrderVo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RequestOrderVo requestOrderVo = (RequestOrderVo) target;
        if (DataStrategyType.GENERAL.equals(requestOrderVo.getOrderType())) {
            doGeneralProductValidate(errors, requestOrderVo);
        }

        if (DataStrategyType.ECOUPON.equals(requestOrderVo.getOrderType())) {
            doECouponProductValidate(errors, requestOrderVo);
        }
    }

    private void doECouponProductValidate(Errors errors, RequestOrderVo requestOrderVo) {
        List<OrderGoodsVo> orderGoodsVoList = requestOrderVo.getOrderGoodsVoList();
        List<ProductVo> productVoList = new ArrayList<>();
        orderGoodsVoList.forEach(orderGoodsVo -> productVoList.add(orderMapper.getGoodsForValidate(orderGoodsVo)));
        for (ProductVo productVo : productVoList) {
            if (!PRD0001.MOBILE_COUPON.getType().equals(productVo.getGoodsTpCd())) {
                errors.reject("isNotECoupon", "해당 상품은 E-Coupon 상품이 아닙니다.");
            }
            Long deliveryAddressCount = (long) requestOrderVo.getDeliveryAddressVoList().size();
            if (!deliveryAddressCount.equals(1L) && !deliveryAddressCount.equals(orderGoodsVoList.get(0).getOrderCount())) {
                    errors.reject("isNotCorrectDeliveryAddressCount", "e 쿠폰의 배송지 수량이 맞지 않습니다.");
            }
        }
    }

    private void doGeneralProductValidate(Errors errors, RequestOrderVo requestOrderVo) {
        List<OrderGoodsVo> orderGoodsVoList = requestOrderVo.getOrderGoodsVoList();
        List<ProductVo> productVoList = new ArrayList<>();
        orderGoodsVoList.forEach(orderGoodsVo -> productVoList.add(orderMapper.getGoodsForValidate(orderGoodsVo)));
        for (ProductVo productVo : productVoList) {
            if (!PRD0001.GENERAL_PRODUCT.getType().equals(productVo.getGoodsTpCd())) {
                errors.reject("isNotGeneralGoods", "해당 상품은 일반 상품이 아닙니다.");
            }

            if (!PRD0002.DELIVERY.getType().equals(productVo.getGoodsDlvTpCd())) {
                errors.reject("isNotGeneralDelivery", "해당 상품은 일반 배송 상품이 아닙니다.");
            }
        }
    }
}
