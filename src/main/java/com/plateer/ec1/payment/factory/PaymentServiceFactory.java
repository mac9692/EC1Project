package com.plateer.ec1.payment.factory;

import com.plateer.ec1.payment.enums.PaymentType;
import com.plateer.ec1.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class PaymentServiceFactory {

    private Map<PaymentType, PaymentService> paymentTypeMap = new LinkedHashMap<>();
    private final List<PaymentService> paymentServiceList;

    public PaymentServiceFactory(List<PaymentService> paymentServiceList) {
        this.paymentServiceList = paymentServiceList;
    }

    @PostConstruct
    public void init() {
        paymentServiceList.forEach(c -> paymentTypeMap.put(c.getType(),c));
    }
    public PaymentService getPaymentService(PaymentType paymentType) {
        log.info("결제 서비스 타입에 맞는 서비스 호출");
        return paymentTypeMap.get(paymentType);
    }

}
