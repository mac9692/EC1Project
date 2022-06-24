package com.plateer.ec1.order.strategy;

import com.plateer.ec1.order.enums.AfterStrategyType;
import com.plateer.ec1.order.vo.Order;
import com.plateer.ec1.order.vo.OrderRequest;

public interface AfterStrategy {

    AfterStrategyType getType();
    void call(OrderRequest orderRequest, Order order);
}
