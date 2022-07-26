package com.plateer.ec1.order.service;

import com.plateer.ec1.order.strategy.AfterStrategy;
import com.plateer.ec1.order.strategy.DataStrategy;
import com.plateer.ec1.order.vo.request.RequestOrderVo;

public interface OrderService {

    public void order(RequestOrderVo requestOrderVo);

    public DataStrategy getDataStrategy(RequestOrderVo requestOrderVo);

    public AfterStrategy getAfterStrategy(RequestOrderVo requestOrderVo);
}
