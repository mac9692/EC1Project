package com.plateer.ec1.payment.service;

import com.plateer.ec1.payment.vo.PayApproveResponseVo;
import com.plateer.ec1.payment.vo.request.RequestCancelVo;
import com.plateer.ec1.payment.vo.request.RequestNetCancelVo;
import com.plateer.ec1.payment.vo.request.RequestPaymentVo;

import java.util.List;

public interface PayService {

    public List<PayApproveResponseVo> approve(RequestPaymentVo requestPaymentVo);

    public void cancel(RequestCancelVo requestCancelVo);

    public void netCancel(RequestNetCancelVo requestNetCancelVo);
}
