package com.plateer.ec1.order.service;

import com.plateer.ec1.order.vo.Order;

public interface OrderRepository {

    void insertOrderBase(Order order);

    void insertOrderProduct(Order order);

    void insertOrderClaim(Order order);

}
