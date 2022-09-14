package com.plateer.ec1.payment.factory;

import com.plateer.ec1.payment.processor.PaymentProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class PaymentProcessorFactory {

    private Map<String, PaymentProcessor> paymentTypeMap = new LinkedHashMap<>();
    private final List<PaymentProcessor> paymentProcessorList;

    public PaymentProcessorFactory(List<PaymentProcessor> paymentProcessorList) {
        this.paymentProcessorList = paymentProcessorList;
    }

    @PostConstruct
    public void init() {
        paymentProcessorList.forEach(c -> paymentTypeMap.put(c.getType(),c));
    }
    public PaymentProcessor getPaymentService(String paymentType) {
        return paymentTypeMap.get(paymentType);
    }

}
