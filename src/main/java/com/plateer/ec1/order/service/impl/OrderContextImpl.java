package com.plateer.ec1.order.service.impl;

import com.plateer.ec1.order.creator.OrderModelCreator;
import com.plateer.ec1.order.mapper.OrderMapper;
import com.plateer.ec1.order.mapper.OrderTrxMapper;
import com.plateer.ec1.order.service.OrderContext;
import com.plateer.ec1.order.service.OrderHistoryService;
import com.plateer.ec1.order.strategy.AfterStrategy;
import com.plateer.ec1.order.strategy.DataStrategy;
import com.plateer.ec1.order.vo.OrderDataVo;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import com.plateer.ec1.payment.service.PayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderContextImpl implements OrderContext {

    private final OrderHistoryService orderHistoryService;
    private final OrderModelCreator orderModelCreator;
    private final PayService payService;
    private final OrderDataInsertProcessor orderDataInsertProcessor;
    private final OrderMapper orderMapper;

    @Transactional
    public void execute(DataStrategy dataStrategy, AfterStrategy afterStrategy, RequestOrderVo requestOrderVo) {
        setOrderNo(requestOrderVo);
        //주문 모니터링 로그 생성
        orderHistoryService.insertOrderHistory(requestOrderVo);
        Long historyNo = requestOrderVo.getLogSeq();

        //주문 데이터 생성
        OrderDataVo orderDataVo = orderModelCreator.create(requestOrderVo);

        //결제
        payService.approve(requestOrderVo.convertToRequestPaymentVo());

        //주문 데이터 등록
        orderDataInsertProcessor.insertOrderData(orderDataVo);

        //금액 검증
        amountValidation(requestOrderVo.getOrderNo());

        //후처리
        afterStrategy.call(requestOrderVo, orderDataVo);

        //주문 모니터링 결과 업데이트
        orderHistoryService.updateOrderHistory(historyNo, orderDataVo);
    }

    private void setOrderNo(RequestOrderVo requestOrderVo) {
        requestOrderVo.setOrderNo(orderMapper.getOrderNo());
    }


    private void amountValidation(String orderNo) {
        log.info("금액 검증 시작");
        log.info("금액 검증 종료");
    }
}
