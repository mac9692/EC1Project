package com.plateer.ec1.order.factory;

import com.plateer.ec1.order.enums.AfterStrategyType;
import com.plateer.ec1.order.strategy.AfterStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class AfterStrategyFactory {

    private Map<AfterStrategyType, AfterStrategy> afterStrategyTypeMap = new LinkedHashMap<>();
    private final List<AfterStrategy> afterStrategyList;

    public AfterStrategyFactory(List<AfterStrategy> afterStrategyList) {
        this.afterStrategyList = afterStrategyList;
    }

    @PostConstruct
    public void init() {
        afterStrategyList.forEach(c -> afterStrategyTypeMap.put(c.getType(),c));
    }

    public AfterStrategy getAfterStrategy(AfterStrategyType afterStrategyType) {
        log.info("후처리 서비스에 맞는 전략 호출");
        return afterStrategyTypeMap.get(afterStrategyType);
    }
}
