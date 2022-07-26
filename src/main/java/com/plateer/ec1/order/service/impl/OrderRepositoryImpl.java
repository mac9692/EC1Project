package com.plateer.ec1.order.service.impl;

import com.plateer.ec1.order.service.OrderRepository;
import com.plateer.ec1.order.vo.OrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class OrderRepositoryImpl implements OrderRepository {


    public void insertOrderBase(OrderVo orderVo) {
        log.info("주문 베이스 데이터 삽입");
    }

    public void insertOrderProduct(OrderVo orderVo) {
        log.info("주문상품 베이스 데이터 삽입");
    }

    public void insertOrderClaim(OrderVo orderVo) {
        log.info("주문 클레임 데이터 삽입");
    }
}
