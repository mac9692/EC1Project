package com.plateer.ec1.order.service;

import com.plateer.ec1.order.vo.OrderDataVo;

public interface OrderRepository {

    void insertOrderBase(OrderDataVo orderDataVo);

    void insertOrderProduct(OrderDataVo orderDataVo);

    void insertOrderClaim(OrderDataVo orderDataVo);

    void insertOrderDelivery(OrderDataVo orderDataVo);

    void insertOrderCost(OrderDataVo orderDataVo);

    void insertOrderBenefit(OrderDataVo orderDataVo);

    void insertOrderBenefitRelation(OrderDataVo orderDataVo);

}
