package com.plateer.ec1.payment.service;

import com.plateer.ec1.payment.enums.PaymentType;
import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.PayApproveResponseVo;
import com.plateer.ec1.payment.vo.request.CancelRequestVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import com.plateer.ec1.payment.vo.request.NetCancelRequestVo;
import com.plateer.ec1.payment.vo.request.PaymentRequestVo;

import java.util.List;

public interface PaymentService {

    PaymentType getType();
    boolean validateAuth(PayInfoVo payInfoVo);

    List<PayApproveResponseVo> approvePay(OrderInfoVo orderInfoVo, PayInfoVo payInfoVo);

    void cancelPay(CancelRequestVo cancelRequestVo);

    void netCancel(NetCancelRequestVo netCancelRequestVo);
}
