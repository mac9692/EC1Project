package com.plateer.ec1.claim.validator;

import com.plateer.ec1.claim.mapper.ClaimMapper;
import com.plateer.ec1.claim.vo.OrderClaimInfoVo;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import com.plateer.ec1.common.code.product.PRD0003;
import com.plateer.ec1.product.vo.ProductVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * 클레임 진행 시 validation을 합니다.(상품 유형, 주문진행상태)
 * 상품판매유형코드 PRD0001, 주문진핸상태코드 OPT0004
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class ClaimValidator implements Validator {
    private final ClaimMapper claimMapper;

    @Override
    public boolean supports(Class<?> clazz) {
        return RequestClaimVo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RequestClaimVo requestClaimVo = (RequestClaimVo) target;
        isValidProduct(errors, requestClaimVo);
    }

    private void isValidProduct(Errors errors, RequestClaimVo requestClaimVo) {
        List<OrderClaimInfoVo> orderClaimInfoVoList = requestClaimVo.getOrderClaimInfoVoList();
        List<ProductVo> productVoList = new ArrayList<>();
        orderClaimInfoVoList.forEach(orderClaimInfoVo -> productVoList.add(claimMapper.getGoodsForValidate(orderClaimInfoVo)));
        for (ProductVo productVo : productVoList) {
            if (productVo == null) {
                errors.reject("goodsItemNotExist", "해당 상품은 존재하지 않습니다.");
                return;
            }
            if (!PRD0003.ON_SALE.getType().equals(productVo.getPrgsStatCd())) {
                errors.rejectValue("orderClaimInfoVoList", "notSaleNow", "해당 상품은 현재 판매 중이 아닙니다.");
            }
        }
    }

    public boolean isValidStatus(RequestClaimVo requestClaimVo) {
        return true;
    }

    public boolean isValidAmount(RequestClaimVo requestClaimVo) {
        return true;
    }

}
