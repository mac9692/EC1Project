package com.plateer.ec1.payment;

import com.plateer.ec1.payment.controller.PaymentController;
import com.plateer.ec1.payment.enums.PaymentType;
import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.request.CancelRequestVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import com.plateer.ec1.payment.vo.request.PaymentRequestVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
@TestMethodOrder(value = MethodOrderer.DisplayName.class)
public class PaymentTest {

    @Autowired
    PaymentController paymentController;

    @Test
    @DisplayName("1. 결제 승인 테스트")
    void approveTest() {
        log.info("1. 결제 승인 테스트 시작");
//        //POINT 테스트
//        PaymentRequestVo paymentRequestVo = new PaymentRequestVo();
//        paymentRequestVo.getPayInfoVoList().get(0).setPaymentType(PaymentType.POINT);
//
//        paymentController.approve(paymentRequestVo);

        //ININCIS 테스트
        PaymentRequestVo paymentRequestVo = new PaymentRequestVo();
        OrderInfoVo orderInfoVo = new OrderInfoVo();
        orderInfoVo.setOrdNo("1");

        List<PayInfoVo> payInfoVoList = new ArrayList<>();
        PayInfoVo payInfoVo = new PayInfoVo();
        payInfoVo.setPaymentType(PaymentType.INICIS);
        payInfoVoList.add(payInfoVo);

        paymentRequestVo.setOrderInfoVo(orderInfoVo);
        paymentRequestVo.setPayInfoVoList(payInfoVoList);

        System.out.println(paymentRequestVo);

        paymentController.approve(paymentRequestVo);

        log.info("1. 결제 승인 테스트 종료");
    }

//    @Test
//    @DisplayName("2. 결제 취소 테스트")
//    void cancelTest() {
//        log.info("2. 결제 취소 테스트 시작");
//        //POINT 테스트
//        CancelRequestVo cancelRequestVo = new CancelRequestVo();
//        cancelRequestVo.setPaymentType(PaymentType.POINT);
//
//        paymentController.cancel(cancelRequestVo);
//
//        //ININCIS 테스트
//        cancelRequestVo.setPaymentType(PaymentType.INICIS);
//        paymentController.cancel(cancelRequestVo);
//
//        log.info("2. 결제 취소 테스트 종료");
//    }
//
//    @Test
//    @DisplayName("3. 결제 망 취소 테스트")
//    void netCancelTest() {
//        log.info("3. 결제 망 취소 테스트 시작");
//        //POINT 테스트
//        CancelRequestVo cancelRequestVo = new CancelRequestVo();
//        cancelRequestVo.setPaymentType(PaymentType.POINT);
//
//        paymentController.netCancel(cancelRequestVo);
//
//        //ININCIS 테스트
//        cancelRequestVo.setPaymentType(PaymentType.INICIS);
//        paymentController.netCancel(cancelRequestVo);
//
//        log.info("3. 결제 망 취소 테스트 종료");
//    }
}
