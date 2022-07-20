package com.plateer.ec1.payment.service.impl;

import com.plateer.ec1.payment.factory.PaymentServiceFactory;
import com.plateer.ec1.payment.mapper.PaymentTrxMapper;
import com.plateer.ec1.payment.service.PayService;
import com.plateer.ec1.payment.service.PaymentService;
import com.plateer.ec1.payment.vo.PayApproveResponseVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import com.plateer.ec1.payment.vo.request.RequestApproveCompleteVo;
import com.plateer.ec1.payment.vo.request.RequestCancelVo;
import com.plateer.ec1.payment.vo.request.RequestNetCancelVo;
import com.plateer.ec1.payment.vo.request.RequestPaymentVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PayServiceImpl implements PayService {

    private final PaymentServiceFactory paymentServiceFactory;
    private final PaymentTrxMapper paymentTrxMapper;

    @Override
    public List<PayApproveResponseVo> approve(RequestPaymentVo requestPaymentVo) {
        List<PayInfoVo> payInfoVoList = requestPaymentVo.getPayInfoVoList();
        for (PayInfoVo payInfoVo: payInfoVoList) {
            PaymentService paymentService = paymentServiceFactory.getPaymentService(payInfoVo.getPaymentType());
            paymentService.approvePay(requestPaymentVo.getOrderInfoVo(), payInfoVo);
        }
        return null;
    }

    @Override
    @Transactional
    public void approveComplete(RequestApproveCompleteVo requestApproveCompleteVo) {
        paymentTrxMapper.updateOpPayInfoComplete(requestApproveCompleteVo);
    }

    @Override
    public void cancel(RequestCancelVo requestCancelVo) {
        PaymentService paymentService = paymentServiceFactory.getPaymentService(requestCancelVo.getPaymentType());
        paymentService.cancelPay(requestCancelVo);
    }

    @Override
    public void netCancel(RequestNetCancelVo requestNetCancelVo) {
        log.info("결제 망취소 서비스 호출");
        PaymentService paymentService = paymentServiceFactory.getPaymentService(requestNetCancelVo.getPaymentType());
        paymentService.netCancel(requestNetCancelVo);
    }
}
