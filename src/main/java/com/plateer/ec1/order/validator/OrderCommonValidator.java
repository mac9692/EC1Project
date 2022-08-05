package com.plateer.ec1.order.validator;

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
public class OrderCommonValidator implements Validator {

    private final OrderMapper orderMapper;
    @Override
    public boolean supports(Class<?> clazz) {
        return RequestOrderVo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RequestOrderVo requestOrderVo = (RequestOrderVo) target;
        doBasicValidate(errors, requestOrderVo);
    }

    private void doBasicValidate(Errors errors, RequestOrderVo requestOrderVo) {
        List<OrderGoodsVo> orderGoodsVoList = requestOrderVo.getOrderGoodsVoList();
        List<ProductVo> productVoList = new ArrayList<>();
        orderGoodsVoList.forEach(orderGoodsVo -> productVoList.add(orderMapper.getGoodsForValidate(orderGoodsVo)));
        for (ProductVo productVo : productVoList) {
            if (Objects.isNull(productVo)) {
                errors.reject("goodsItemNotExist", "해당 상품은 존재하지 않습니다.");
            }
        }
    }
}
