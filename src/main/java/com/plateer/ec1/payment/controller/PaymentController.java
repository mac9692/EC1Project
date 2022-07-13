package com.plateer.ec1.payment.controller;

import com.plateer.ec1.payment.service.PayService;
import com.plateer.ec1.payment.vo.PayApproveResponseVo;
import com.plateer.ec1.payment.vo.request.RequestApproveCompleteVo;
import com.plateer.ec1.payment.vo.request.RequestCancelVo;
import com.plateer.ec1.payment.vo.request.RequestNetCancelVo;
import com.plateer.ec1.payment.vo.request.RequestPaymentVo;
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
    public List<PayApproveResponseVo> approve(RequestPaymentVo requestPaymentVo) {
        return payService.approve(requestPaymentVo);
    }

    @PostMapping(path = "approveComplete")
    public String approveComplete(RequestApproveCompleteVo requestApproveCompleteVo) {
        log.info(String.valueOf(requestApproveCompleteVo));
        return "OK";
    }

    @RequestMapping(path = "cancel")
    public void cancel(RequestCancelVo requestCancelVo) {
        payService.cancel(requestCancelVo);
    }

    @RequestMapping(path = "netcancel")
    public void netCancel(RequestNetCancelVo requestNetCancelVo) {
        payService.netCancel(requestNetCancelVo);
    }

}
