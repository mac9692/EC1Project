package com.plateer.ec1.payment.service.impl;

import com.plateer.ec1.payment.factory.PaymentServiceFactory;
import com.plateer.ec1.payment.service.PayService;
import com.plateer.ec1.payment.service.PaymentService;
import com.plateer.ec1.payment.vo.ApproveResponseVo;
import com.plateer.ec1.payment.vo.CancelRequestVo;
import com.plateer.ec1.payment.vo.PayInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PayServiceImpl implements PayService {

    private final PaymentServiceFactory paymentServiceFactory;

    @Override
    public ApproveResponseVo approve(PayInfo payInfo) {
        log.info("결제 승인 서비스 호출");
        PaymentService paymentService = paymentServiceFactory.getPaymentService(payInfo.getPaymentType());
        return paymentService.approvePay(payInfo);
    }

    @Override
    public void cancel(CancelRequestVo cancelRequestVo) {
        log.info("결제 취소 서비스 호출");
        PaymentService paymentService = paymentServiceFactory.getPaymentService(cancelRequestVo.getPaymentType());
        paymentService.cancelPay(cancelRequestVo);
    }

    @Override
    public void netCancel(CancelRequestVo cancelRequestVo) {
        log.info("결제 망취소 서비스 호출");
        PaymentService paymentService = paymentServiceFactory.getPaymentService(cancelRequestVo.getPaymentType());
        paymentService.netCancel(cancelRequestVo);
    }
}
