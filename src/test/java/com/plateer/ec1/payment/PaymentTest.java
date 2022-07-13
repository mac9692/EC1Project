package com.plateer.ec1.payment;

import com.plateer.ec1.common.code.order.OPT0013;
import com.plateer.ec1.payment.controller.PaymentController;
import com.plateer.ec1.payment.enums.PaymentType;
import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import com.plateer.ec1.payment.vo.request.RequestApproveCompleteVo;
import com.plateer.ec1.payment.vo.request.RequestPaymentVo;
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
    @DisplayName("1. 이니시스 - 결제 승인 테스트")
    void approveTest() {
        RequestPaymentVo requestPaymentVo = new RequestPaymentVo();
        OrderInfoVo orderInfoVo = new OrderInfoVo();
        orderInfoVo.setOrdNo("1");
        orderInfoVo.setBuyerName("박진성");
        orderInfoVo.setBuyerEmail("박진성 이메일");
        orderInfoVo.setGoodName("새우깡");
        orderInfoVo.setMoid("192938127892-2328382");
        orderInfoVo.setStoreUrl("https://abc.com");

        List<PayInfoVo> payInfoVoList = new ArrayList<>();
        PayInfoVo payInfoVo1 = new PayInfoVo();
        payInfoVo1.setPaymentType(PaymentType.INICIS);
        payInfoVo1.setPayAmount(1L);
        payInfoVo1.setBankCode(OPT0013.NH.getType());
        payInfoVo1.setDepositorName("박진성");

        PayInfoVo payInfoVo2 = new PayInfoVo();
        payInfoVo2.setPaymentType(PaymentType.INICIS);
        payInfoVo2.setPayAmount(1L);
        payInfoVo2.setBankCode(OPT0013.NH.getType());
        payInfoVo2.setDepositorName("박진성");

        payInfoVoList.add(payInfoVo1);
        payInfoVoList.add(payInfoVo2);

        requestPaymentVo.setOrderInfoVo(orderInfoVo);
        requestPaymentVo.setPayInfoVoList(payInfoVoList);

        System.out.println(requestPaymentVo);

        paymentController.approve(requestPaymentVo);
    }

    @Test
    @DisplayName("2. 입금 완료 테스트")
    void approveCompleteTest() {

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
