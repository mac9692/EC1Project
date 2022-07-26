package com.plateer.ec1.order.service;

import com.plateer.ec1.order.vo.OrderVo;
import com.plateer.ec1.order.vo.request.RequestOrderVo;

public interface OrderHistoryService {

    public Long insertOrderHistory(RequestOrderVo requestOrderVo);

    public void updateOrderHistory(Long historyNo, OrderVo orderVo);
}
