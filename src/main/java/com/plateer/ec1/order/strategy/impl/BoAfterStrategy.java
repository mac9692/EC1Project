package com.plateer.ec1.order.strategy.impl;

import com.plateer.ec1.order.enums.AfterStrategyType;
import com.plateer.ec1.order.strategy.AfterStrategy;
import com.plateer.ec1.order.vo.Order;
import com.plateer.ec1.order.vo.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BoAfterStrategy implements AfterStrategy {
    @Override
    public AfterStrategyType getType() {
        return AfterStrategyType.BO;
    }

    @Override
    public void call(OrderRequest orderRequest, Order order) {
        log.info("Bo 후처리 전략 시작");
        log.info("Bo 후처리 전략 종료");
    }
}
