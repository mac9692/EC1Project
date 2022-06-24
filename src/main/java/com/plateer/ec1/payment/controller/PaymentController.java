package com.plateer.ec1.payment.controller;

import com.plateer.ec1.payment.service.PayService;
import com.plateer.ec1.payment.vo.ApproveResponseVo;
import com.plateer.ec1.payment.vo.CancelRequestVo;
import com.plateer.ec1.payment.vo.PayInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "payment")
public class PaymentController {

    private final PayService payService;

    @RequestMapping(path = "approve")
    public ApproveResponseVo approve(PayInfo payInfo) {
        log.info("결제 요청 승인 시작");
        return payService.approve(payInfo);
    }

    @RequestMapping(path = "cancel")
    public void cancel(CancelRequestVo cancelRequestVo) {
        log.info("결제 취소 시작");
        payService.cancel(cancelRequestVo);
    }

    @RequestMapping(path = "netcancel")
    public void netCancel(CancelRequestVo cancelRequestVo) {
        log.info("결제 망취소 시작");
        payService.netCancel(cancelRequestVo);
    }

}
