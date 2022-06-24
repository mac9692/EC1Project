package com.plateer.ec1.order.service;

import com.plateer.ec1.order.vo.Order;
import com.plateer.ec1.order.vo.OrderRequest;

public interface OrderHistoryService {

    public Long insertOrderHistory(OrderRequest orderRequest);

    public void updateOrderHistory(Long historyNo, Order order);
}
