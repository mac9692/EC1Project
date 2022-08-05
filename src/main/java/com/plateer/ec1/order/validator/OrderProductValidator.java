package com.plateer.ec1.order.validator;

import com.plateer.ec1.common.code.product.PRD0003;
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
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class OrderProductValidator implements Validator {

    private final OrderMapper orderMapper;

    @Override
    public boolean supports(Class<?> clazz) {
        return RequestOrderVo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RequestOrderVo requestOrderVo = (RequestOrderVo) target;
        doProductValidate(errors, requestOrderVo);
    }

    private void doProductValidate(Errors errors, RequestOrderVo requestOrderVo) {
        List<OrderGoodsVo> orderGoodsVoList = requestOrderVo.getOrderGoodsVoList();
        List<ProductVo> productVoList = new ArrayList<>();
        orderGoodsVoList.forEach(orderGoodsVo -> productVoList.add(orderMapper.getGoodsForValidate(orderGoodsVo)));
        for (ProductVo productVo : productVoList) {
            if (Objects.isNull(productVo)) {
                errors.reject("goodsItemNotExist", "해당 상품은 존재하지 않습니다.");
            }

            if (!PRD0003.ON_SALE.getType().equals(productVo.getPrgsStatCd())) {
                errors.rejectValue("prgsStatCd", "notSaleNow", "해당 상품은 현재 판매 중이 아닙니다.");
            }
        }
    }
}
