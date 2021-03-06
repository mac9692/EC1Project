package com.plateer.ec1.order.service;

import com.plateer.ec1.order.strategy.AfterStrategy;
import com.plateer.ec1.order.strategy.DataStrategy;
import com.plateer.ec1.order.vo.request.RequestOrderVo;

public interface OrderContext {

    public void execute(DataStrategy dataStrategy, AfterStrategy afterStrategy, RequestOrderVo requestOrderVo);
}
