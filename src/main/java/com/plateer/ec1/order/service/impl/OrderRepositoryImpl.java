package com.plateer.ec1.order.service.impl;

import com.plateer.ec1.order.service.OrderRepository;
import com.plateer.ec1.order.vo.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class OrderRepositoryImpl implements OrderRepository {


    public void insertOrderBase(Order order) {
        log.info("주문 베이스 데이터 삽입");
    }

    public void insertOrderProduct(Order order) {
        log.info("주문상품 베이스 데이터 삽입");
    }

    public void insertOrderClaim(Order order) {
        log.info("주문 클레임 데이터 삽입");
    }
}
