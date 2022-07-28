package com.plateer.ec1.order.strategy;

import com.plateer.ec1.order.enums.AfterStrategyType;
import com.plateer.ec1.order.vo.OrderDataVo;
import com.plateer.ec1.order.vo.request.RequestOrderVo;

public interface AfterStrategy {

    AfterStrategyType getType();
    void call(RequestOrderVo requestOrderVo, OrderDataVo orderDataVo);
}
