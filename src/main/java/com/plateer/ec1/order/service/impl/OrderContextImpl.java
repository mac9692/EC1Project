package com.plateer.ec1.order.service.impl;

import com.plateer.ec1.order.service.OrderContext;
import com.plateer.ec1.order.service.OrderHistoryService;
import com.plateer.ec1.order.service.OrderRepository;
import com.plateer.ec1.order.strategy.AfterStrategy;
import com.plateer.ec1.order.strategy.DataStrategy;
import com.plateer.ec1.order.vo.Order;
import com.plateer.ec1.order.vo.OrderProductView;
import com.plateer.ec1.order.vo.OrderRequest;
import com.plateer.ec1.payment.service.PayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderContextImpl implements OrderContext {

    private final OrderHistoryService orderHistoryService;
    private final PayService payService;
    private final OrderRepository orderRepository;

    @Override
    public void execute(DataStrategy dataStrategy, AfterStrategy afterStrategy, OrderRequest orderRequest) {
        log.info("주문 생성 시작");

        //주문 모니터링 로그 생성
        Long historyNo = orderHistoryService.insertOrderHistory(orderRequest);

        //주문 데이터 생성
        Order order = dataStrategy.create(orderRequest, new OrderProductView());

        //결제
//        payService.approve(orderRequest.getPayInfo());

        //주문 데이터 등록
        insertOrderData(order);

        //금액 검증
        amountValidation(orderRequest.getOrderNo());

        //후처리
        afterStrategy.call(orderRequest, order);

        //주문 모니터링 결과 업데이트
        orderHistoryService.updateOrderHistory(historyNo, order);

        log.info("주문 생성 종료");
    }

    private void insertOrderData(Order order) {
        log.info("주문 데이터 등록 시작");
        orderRepository.insertOrderBase(order);
        orderRepository.insertOrderProduct(order);
        orderRepository.insertOrderClaim(order);
        log.info("주문 데이터 등록 종료");
    }

    private void amountValidation(String orderNo) {
        log.info("금액 검증 시작");
        log.info("금액 검증 종료");
    }
}
