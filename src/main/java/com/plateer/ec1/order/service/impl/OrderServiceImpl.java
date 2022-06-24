package com.plateer.ec1.order.service.impl;

import com.plateer.ec1.order.factory.AfterStrategyFactory;
import com.plateer.ec1.order.factory.DataStrategyFactory;
import com.plateer.ec1.order.service.OrderContext;
import com.plateer.ec1.order.service.OrderService;
import com.plateer.ec1.order.strategy.AfterStrategy;
import com.plateer.ec1.order.strategy.DataStrategy;
import com.plateer.ec1.order.vo.OrderRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final AfterStrategyFactory afterStrategyFactory;
    private final DataStrategyFactory dataStrategyFactory;
    private final OrderContext orderContext;


    @Override
    public void order(OrderRequest orderRequest) {
        log.info("주문하기 서비스 실행");
        orderContext.execute(getDataStrategy(orderRequest), getAfterStrategy(orderRequest), orderRequest);
    }

    @Override
    public DataStrategy getDataStrategy(OrderRequest orderRequest) {
        log.info("주문 전략 호출 시작");
        return dataStrategyFactory.getDataStrategy(orderRequest.getOrderType());
    }

    @Override
    public AfterStrategy getAfterStrategy(OrderRequest orderRequest) {
        log.info("후처리 전략 호출 시작");
        return afterStrategyFactory.getAfterStrategy(orderRequest.getSystemType());
    }
}
