package com.plateer.ec1.order.service.impl;

import com.plateer.ec1.order.service.OrderRepository;
import com.plateer.ec1.order.vo.OrderDataVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public void insertOrderBase(OrderDataVo orderDataVo) {
        log.info("주문 베이스 데이터 삽입");
    }

    @Override
    public void insertOrderProduct(OrderDataVo orderDataVo) {
        log.info("주문상품 베이스 데이터 삽입");
    }

    @Override
    public void insertOrderClaim(OrderDataVo orderDataVo) {
        log.info("주문 클레임 데이터 삽입");
    }

    @Override
    public void insertOrderDelivery(OrderDataVo orderDataVo) {

    }

    @Override
    public void insertOrderCost(OrderDataVo orderDataVo) {

    }

    @Override
    public void insertOrderBenefit(OrderDataVo orderDataVo) {

    }

    @Override
    public void insertOrderBenefitRelation(OrderDataVo orderDataVo) {

    }
}
