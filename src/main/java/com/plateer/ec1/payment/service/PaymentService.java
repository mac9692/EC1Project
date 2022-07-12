package com.plateer.ec1.payment.service;

import com.plateer.ec1.payment.enums.PaymentType;
import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.PayApproveResponseVo;
import com.plateer.ec1.payment.vo.request.RequestCancelVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import com.plateer.ec1.payment.vo.request.RequestNetCancelVo;

import java.util.List;

public interface PaymentService {

    PaymentType getType();
    boolean validatePGAuth(PayInfoVo payInfoVo);

    List<PayApproveResponseVo> approvePay(OrderInfoVo orderInfoVo, PayInfoVo payInfoVo);

    void cancelPay(RequestCancelVo requestCancelVo);

    void netCancel(RequestNetCancelVo requestNetCancelVo);
}
