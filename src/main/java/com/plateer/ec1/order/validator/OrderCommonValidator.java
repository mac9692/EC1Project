package com.plateer.ec1.order.validator;

import com.plateer.ec1.order.vo.request.RequestOrderVo;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class OrderCommonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return RequestOrderVo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RequestOrderVo requestOrderVo = (RequestOrderVo) target;


    }
}
