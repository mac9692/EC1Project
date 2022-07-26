package com.plateer.ec1.order.service;

import com.plateer.ec1.order.vo.OrderVo;

public interface OrderRepository {

    void insertOrderBase(OrderVo orderVo);

    void insertOrderProduct(OrderVo orderVo);

    void insertOrderClaim(OrderVo orderVo);

}
