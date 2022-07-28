package com.plateer.ec1.order.service;

import com.plateer.ec1.order.vo.OrderDataVo;
import com.plateer.ec1.order.vo.OrderVo;
import com.plateer.ec1.order.vo.request.RequestOrderVo;

public interface OrderHistoryService {

    public Long insertOrderHistory(RequestOrderVo requestOrderVo);

    public Long updateOrderHistory(Long historyNo, OrderDataVo orderDataVo);
}
