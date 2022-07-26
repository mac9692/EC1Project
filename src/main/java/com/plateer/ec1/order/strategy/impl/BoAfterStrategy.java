package com.plateer.ec1.order.strategy.impl;

import com.plateer.ec1.order.enums.AfterStrategyType;
import com.plateer.ec1.order.strategy.AfterStrategy;
import com.plateer.ec1.order.vo.OrderVo;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BoAfterStrategy implements AfterStrategy {
    @Override
    public AfterStrategyType getType() {
        return AfterStrategyType.BO;
    }

    @Override
    public void call(RequestOrderVo requestOrderVo, OrderVo orderVo) {
        log.info("Bo 후처리 전략 시작");
        log.info("Bo 후처리 전략 종료");
    }
}
