package com.plateer.ec1.payment.processor;

import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.PayApproveResponseVo;
import com.plateer.ec1.payment.vo.request.RequestCancelVo;
import com.plateer.ec1.payment.vo.PayInfoVo;

import java.util.List;

public interface PaymentProcessor {

    String getType();
    boolean validatePGAuth(PayInfoVo payInfoVo);

    List<PayApproveResponseVo> approvePay(OrderInfoVo orderInfoVo, PayInfoVo payInfoVo);

    void cancelPay(RequestCancelVo requestCancelVo);
}
