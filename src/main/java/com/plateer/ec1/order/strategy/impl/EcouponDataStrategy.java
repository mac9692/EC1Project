package com.plateer.ec1.order.strategy.impl;

import com.plateer.ec1.order.creator.OrderModelCreators;
import com.plateer.ec1.order.enums.DataStrategyType;
import com.plateer.ec1.order.strategy.DataStrategy;
import com.plateer.ec1.order.vo.Order;
import com.plateer.ec1.order.vo.OrderProductView;
import com.plateer.ec1.order.vo.OrderRequest;
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
    public Order create(OrderRequest orderRequest, OrderProductView orderProductView) {
        log.info("Ecoupon 전략 데이터 생성");
        OrderModelCreators.commonOrderBase(orderRequest, orderProductView);
        OrderModelCreators.commonOrderProduct(orderRequest, orderProductView);
        OrderModelCreators.commonOrderClaim(orderRequest, orderProductView);
        log.info("Ecoupon 전략 데이터 종료");
        return null;
    }
}
