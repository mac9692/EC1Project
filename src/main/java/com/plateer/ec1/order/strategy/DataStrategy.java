package com.plateer.ec1.order.strategy;

import com.plateer.ec1.order.vo.OrderDataVo;
import com.plateer.ec1.order.vo.request.RequestOrderVo;

public interface DataStrategy {

    String getType();
    public OrderDataVo create(RequestOrderVo requestOrderVo);
}
