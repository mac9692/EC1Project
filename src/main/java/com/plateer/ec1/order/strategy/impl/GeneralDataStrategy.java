package com.plateer.ec1.order.strategy.impl;

import com.plateer.ec1.order.creator.OrderModelCreators;
import com.plateer.ec1.order.enums.DataStrategyType;
import com.plateer.ec1.order.strategy.DataStrategy;
import com.plateer.ec1.order.vo.Order;
import com.plateer.ec1.order.vo.OrderProductView;
import com.plateer.ec1.order.vo.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GeneralDataStrategy implements DataStrategy {
    @Override
    public DataStrategyType getType() {
        return DataStrategyType.GENERAL;
    }

    @Override
    public Order create(OrderRequest orderRequest, OrderProductView orderProductView) {
        log.info("일반 상품 데이터 생성 시작");
        OrderModelCreators.commonOrderBase(orderRequest, orderProductView);
        OrderModelCreators.commonOrderProduct(orderRequest, orderProductView);
        OrderModelCreators.commonOrderClaim(orderRequest, orderProductView);
        log.info("일반 상품 데이터 생성 종료");
        return null;
    }
}
