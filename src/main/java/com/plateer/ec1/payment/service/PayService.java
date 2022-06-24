package com.plateer.ec1.payment.service;

import com.plateer.ec1.payment.vo.ApproveResponseVo;
import com.plateer.ec1.payment.vo.CancelRequestVo;
import com.plateer.ec1.payment.vo.PayInfo;

public interface PayService {

    public ApproveResponseVo approve(PayInfo payInfo);

    public void cancel(CancelRequestVo cancelRequestVo);

    public void netCancel(CancelRequestVo cancelRequestVo);
}
