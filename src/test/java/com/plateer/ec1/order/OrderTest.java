package com.plateer.ec1.order;

import com.plateer.ec1.order.controller.OrderController;
import com.plateer.ec1.order.enums.AfterStrategyType;
import com.plateer.ec1.order.enums.DataStrategyType;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import com.plateer.ec1.payment.enums.PaymentType;
import com.plateer.ec1.payment.vo.PayInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
@TestMethodOrder(value = MethodOrderer.DisplayName.class)
public class OrderTest {

    @Autowired
    OrderController orderController;

    @Test
    @DisplayName("1. 주문 테스트 - Ecoupon, BO, POINT")
    void orderTest() {
        PayInfoVo payInfoVo = new PayInfoVo();
        payInfoVo.setPaymentType(PaymentType.POINT);
        RequestOrderVo requestOrderVo = RequestOrderVo
                .builder()
                .orderType(DataStrategyType.ECOUPON)
                .systemType(AfterStrategyType.BO)
                .payInfoVo(payInfoVo)
                .build();

        orderController.order(requestOrderVo);
    }

    @Test
    @DisplayName("2. 주문 테스트 - GENERAL, FO, INICIS")
    void orderTest2() {
        PayInfoVo payInfo = new PayInfoVo();
        payInfo.setPaymentType(PaymentType.INICIS);
        RequestOrderVo requestOrderVo = RequestOrderVo
                .builder()
                .orderType(DataStrategyType.GENERAL)
                .systemType(AfterStrategyType.FO)
                .payInfoVo(payInfo)
                .build();

        orderController.order(requestOrderVo);
    }
}
