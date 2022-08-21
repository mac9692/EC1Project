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
import java.util.Objects;

/**
 * 클레임 진행 시 validation을 한다(상품 유형, 주문진행상태)
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
        log.info("검증합니다.");
        RequestClaimVo requestClaimVo = (RequestClaimVo) target;
        doProductValidate(errors, requestClaimVo);
    }

    private void doProductValidate(Errors errors, RequestClaimVo requestClaimVo) {
        log.info("검증합니다.");
        List<OrderClaimInfoVo> orderClaimInfoVoList = requestClaimVo.getOrderClaimInfoVoList();
        List<ProductVo> productVoList = new ArrayList<>();
        orderClaimInfoVoList.forEach(orderClaimInfoVo -> productVoList.add(claimMapper.getGoodsForValidate(orderClaimInfoVo)));
        for (ProductVo productVo : productVoList) {
            if (productVo == null) {
                errors.reject("goodsItemNotExist", "해당 상품은 존재하지 않습니다.");
            }

            if (!PRD0003.ON_SALE.getType().equals(productVo.getPrgsStatCd())) {
                errors.rejectValue("orderClaimInfoVoList", "notSaleNow", "해당 상품은 현재 판매 중이 아닙니다.");
            }
        }
    }


    public void isValidStatus(RequestClaimVo requestClaimVo) {
        log.info("검증 시작 : 상태 검증");
    }

    public void isValidAmount(RequestClaimVo requestClaimVo) {
        log.info("검증 시작 : 금액 검증");
    }

    public void verifyAmount(RequestClaimVo requestClaimVo) {
        log.info("검증 시작 : 재고 검증");
    }

}
