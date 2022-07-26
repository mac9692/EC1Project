package com.plateer.ec1.order.strategy;

import com.plateer.ec1.order.enums.DataStrategyType;
import com.plateer.ec1.order.vo.OrderVo;
import com.plateer.ec1.order.vo.OrderProductView;
import com.plateer.ec1.order.vo.request.RequestOrderVo;

public interface DataStrategy {

    DataStrategyType getType();
    public OrderVo create(RequestOrderVo requestOrderVo, OrderProductView orderProductView);
}
