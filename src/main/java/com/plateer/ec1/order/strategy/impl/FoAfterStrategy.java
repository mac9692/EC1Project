package com.plateer.ec1.order.strategy.impl;

import com.plateer.ec1.order.enums.AfterStrategyType;
import com.plateer.ec1.order.strategy.AfterStrategy;
import com.plateer.ec1.order.vo.OrderVo;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FoAfterStrategy implements AfterStrategy {
    @Override
    public AfterStrategyType getType() {
        return AfterStrategyType.FO;
    }

    @Override
    public void call(RequestOrderVo requestOrderVo, OrderVo orderVo) {
        log.info("Fo후처리 시작");
        log.info("Fo후처리 종료");
    }
}
