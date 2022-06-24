package com.plateer.ec1.order.strategy;

import com.plateer.ec1.order.enums.DataStrategyType;
import com.plateer.ec1.order.vo.Order;
import com.plateer.ec1.order.vo.OrderProductView;
import com.plateer.ec1.order.vo.OrderRequest;

public interface DataStrategy {

    DataStrategyType getType();
    public Order create(OrderRequest orderRequest, OrderProductView orderProductView);
}
