package com.plateer.ec1.payment.controller;

import com.plateer.ec1.payment.service.PayService;
import com.plateer.ec1.payment.vo.PayApproveResponseVo;
import com.plateer.ec1.payment.vo.request.CancelRequestVo;
import com.plateer.ec1.payment.vo.request.NetCancelRequestVo;
import com.plateer.ec1.payment.vo.request.PaymentRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "payment")
public class PaymentController {

    private final PayService payService;

    @PostMapping(path = "approve")
    public List<PayApproveResponseVo> approve(PaymentRequestVo paymentRequestVo) {
        log.info("결제 요청 승인 시작");
        return payService.approve(paymentRequestVo);
    }

    @RequestMapping(path = "cancel")
    public void cancel(CancelRequestVo cancelRequestVo) {
        log.info("결제 취소 시작");
        payService.cancel(cancelRequestVo);
    }

    @RequestMapping(path = "netcancel")
    public void netCancel(NetCancelRequestVo netCancelRequestVo) {
        log.info("결제 망취소 시작");
        payService.netCancel(netCancelRequestVo);
    }

}
