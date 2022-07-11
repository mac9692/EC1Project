package com.plateer.ec1.payment.service.impl;

import com.plateer.ec1.payment.factory.PaymentServiceFactory;
import com.plateer.ec1.payment.service.PayService;
import com.plateer.ec1.payment.service.PaymentService;
import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.PayApproveResponseVo;
import com.plateer.ec1.payment.vo.request.CancelRequestVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import com.plateer.ec1.payment.vo.request.NetCancelRequestVo;
import com.plateer.ec1.payment.vo.request.PaymentRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PayServiceImpl implements PayService {

    private final PaymentServiceFactory paymentServiceFactory;

    @Override
    public List<PayApproveResponseVo> approve(PaymentRequestVo paymentRequestVo) {
        log.info("결제 승인 서비스 호출");
        PaymentService paymentService = paymentServiceFactory.getPaymentService(paymentRequestVo.getPayInfoVoList().get(0).getPaymentType());
        return paymentService.approvePay(paymentRequestVo.getOrderInfoVo(), paymentRequestVo.getPayInfoVoList().get(0));
    }

    @Override
    public void cancel(CancelRequestVo cancelRequestVo) {
        log.info("결제 취소 서비스 호출");
        PaymentService paymentService = paymentServiceFactory.getPaymentService(cancelRequestVo.getPaymentType());
        paymentService.cancelPay(cancelRequestVo);
    }

    @Override
    public void netCancel(NetCancelRequestVo netCancelRequestVo) {
        log.info("결제 망취소 서비스 호출");
        PaymentService paymentService = paymentServiceFactory.getPaymentService(netCancelRequestVo.getPaymentType());
        paymentService.netCancel(netCancelRequestVo);
    }
}
