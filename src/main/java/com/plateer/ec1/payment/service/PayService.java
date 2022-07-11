package com.plateer.ec1.payment.service;

import com.plateer.ec1.payment.vo.PayApproveResponseVo;
import com.plateer.ec1.payment.vo.request.CancelRequestVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import com.plateer.ec1.payment.vo.request.NetCancelRequestVo;
import com.plateer.ec1.payment.vo.request.PaymentRequestVo;

import java.util.List;

public interface PayService {

    public List<PayApproveResponseVo> approve(PaymentRequestVo paymentRequestVo);

    public void cancel(CancelRequestVo cancelRequestVo);

    public void netCancel(NetCancelRequestVo netCancelRequestVo);
}
