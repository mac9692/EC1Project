package com.plateer.ec1.promotion.factory;

import com.plateer.ec1.promotion.enums.PromotionType;
import com.plateer.ec1.promotion.processor.CalProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class CalculatorFactory {

    private Map<PromotionType, CalProcessor> promotionTypeCalculatorMap = new LinkedHashMap<>();
    private final List<CalProcessor> calculatorList;

    public CalculatorFactory(List<CalProcessor> calculatorList) {
        this.calculatorList = calculatorList;
    }

    @PostConstruct
    public void init() {
        calculatorList.forEach(c -> promotionTypeCalculatorMap.put(c.getType(), c));
    }

    public CalProcessor getPromotionCalculator(PromotionType promotionType) {
        return promotionTypeCalculatorMap.get(promotionType);
    }

}

