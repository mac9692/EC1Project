package com.plateer.ec1.order.strategy;

import com.plateer.ec1.order.enums.DataStrategyType;
import com.plateer.ec1.order.vo.OrderDataVo;
import com.plateer.ec1.order.vo.OrderProductView;
import com.plateer.ec1.order.vo.request.RequestOrderVo;

public interface DataStrategy {

    DataStrategyType getType();
    public OrderDataVo create(RequestOrderVo requestOrderVo);
}
