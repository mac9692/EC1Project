package com.plateer.ec1.order.strategy.impl;

import com.plateer.ec1.order.creator.OrderModelCreators;
import com.plateer.ec1.order.enums.DataStrategyType;
import com.plateer.ec1.order.strategy.DataStrategy;
import com.plateer.ec1.order.vo.OrderVo;
import com.plateer.ec1.order.vo.OrderProductView;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EcouponDataStrategy implements DataStrategy {

    @Override
    public DataStrategyType getType() {
        return DataStrategyType.ECOUPON;
    }

    @Override
    public OrderVo create(RequestOrderVo requestOrderVo, OrderProductView orderProductView) {
        log.info("Ecoupon 전략 데이터 생성");
        OrderModelCreators.commonOrderBase(requestOrderVo, orderProductView);
        OrderModelCreators.commonOrderProduct(requestOrderVo, orderProductView);
        OrderModelCreators.commonOrderClaim(requestOrderVo, orderProductView);
        log.info("Ecoupon 전략 데이터 종료");
        return null;
    }
}
