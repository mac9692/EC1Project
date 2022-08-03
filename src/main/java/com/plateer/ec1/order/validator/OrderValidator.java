package com.plateer.ec1.order.validator;

import com.plateer.ec1.order.enums.AfterStrategyType;
import com.plateer.ec1.order.enums.DataStrategyType;
import com.plateer.ec1.order.vo.request.RequestOrderVo;

import java.util.function.Predicate;

public enum OrderValidator {
    FO_GENERAL(AfterStrategyType.FO, DataStrategyType.GENERAL),
    BO_GENERAL(AfterStrategyType.BO, DataStrategyType.GENERAL),
    FO_ECOUPON(AfterStrategyType.FO, DataStrategyType.ECOUPON),
    BO_ECOUPON(AfterStrategyType.BO, DataStrategyType.ECOUPON);

    private AfterStrategyType afterStrategyType;
    private DataStrategyType dataStrategyType;


    OrderValidator(AfterStrategyType afterStrategyType, DataStrategyType dataStrategyType) {
        this.afterStrategyType = afterStrategyType;
        this.dataStrategyType = dataStrategyType;
    }

    public static OrderValidator get(RequestOrderVo requestOrderVo) {
        return OrderValidator.BO_ECOUPON;
    }
}
