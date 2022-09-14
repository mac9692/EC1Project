package com.plateer.ec1.payment.service.impl;

import com.plateer.ec1.payment.factory.PaymentProcessorFactory;
import com.plateer.ec1.payment.mapper.PaymentTrxMapper;
import com.plateer.ec1.payment.service.PayService;
import com.plateer.ec1.payment.processor.PaymentProcessor;
import com.plateer.ec1.payment.vo.PayApproveResponseVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import com.plateer.ec1.payment.vo.request.RequestApproveCompleteVo;
import com.plateer.ec1.payment.vo.request.RequestCancelVo;
import com.plateer.ec1.payment.vo.request.RequestPaymentVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PayServiceImpl implements PayService {

    private final PaymentProcessorFactory paymentProcessorFactory;
    private final PaymentTrxMapper paymentTrxMapper;

    @Override
    public List<PayApproveResponseVo> approve(RequestPaymentVo requestPaymentVo) {
        List<PayInfoVo> payInfoVoList = requestPaymentVo.getPayInfoVoList();
        for (PayInfoVo payInfoVo: payInfoVoList) {
            PaymentProcessor paymentProcessor = paymentProcessorFactory.getPaymentService(payInfoVo.getPaymentType());
            paymentProcessor.approvePay(requestPaymentVo.getOrderInfoVo(), payInfoVo);
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
        PaymentProcessor paymentProcessor = paymentProcessorFactory.getPaymentService(requestCancelVo.getPaymentType());
        paymentProcessor.cancelPay(requestCancelVo);
    }
}
