package com.plateer.ec1.order.strategy.impl.after;

import com.plateer.ec1.common.code.order.OPT0012;
import com.plateer.ec1.order.enums.AfterStrategyType;
import com.plateer.ec1.order.strategy.AfterStrategy;
import com.plateer.ec1.order.vo.OrderDataVo;
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
    public void call(RequestOrderVo requestOrderVo, OrderDataVo orderDataVo) {
        orderDataVo.setProcCcd(OPT0012.SUCCESS.getType());
    }
}
