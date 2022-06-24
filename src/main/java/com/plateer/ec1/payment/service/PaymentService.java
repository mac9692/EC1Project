package com.plateer.ec1.payment.service;

import com.plateer.ec1.payment.enums.PaymentType;
import com.plateer.ec1.payment.vo.ApproveResponseVo;
import com.plateer.ec1.payment.vo.CancelRequestVo;
import com.plateer.ec1.payment.vo.PayInfo;

public interface PaymentService {

    PaymentType getType();
    void validateAuth(PayInfo payInfo);

    ApproveResponseVo approvePay(PayInfo payInfo);

    void cancelPay(CancelRequestVo cancelRequestVo);

    void netCancel(CancelRequestVo cancelRequestVo);
}
