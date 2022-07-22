package com.plateer.ec1.payment.service.impl;

import com.plateer.ec1.common.code.order.OPT0009;
import com.plateer.ec1.common.code.order.OPT0010;
import com.plateer.ec1.common.code.order.OPT0011;
import com.plateer.ec1.common.model.order.OpPayInfo;
import com.plateer.ec1.payment.enums.PaymentType;
import com.plateer.ec1.payment.mapper.PaymentMapper;
import com.plateer.ec1.payment.mapper.PaymentTrxMapper;
import com.plateer.ec1.payment.service.PaymentService;
import com.plateer.ec1.payment.vo.OrderBaseVo;
import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.PayApproveResponseVo;
import com.plateer.ec1.payment.vo.request.RequestCancelVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import com.plateer.ec1.payment.vo.request.RequestNetCancelVo;
import com.plateer.ec1.payment.vo.response.ResponseApproveVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class Point implements PaymentService {

    private final PaymentMapper paymentMapper;
    private final PaymentTrxMapper paymentTrxMapper;

    @Override
    public PaymentType getType() {
        return PaymentType.POINT;
    }

    @Override
    public boolean validatePGAuth(PayInfoVo payInfo) {
        return true;
    }

    @Transactional
    @Override
    public List<PayApproveResponseVo> approvePay(OrderInfoVo orderInfoVo, PayInfoVo payInfoVo) {
        if (validatePGAuth(payInfoVo)) {
            insertApproveDataOpPayInfo(orderInfoVo, payInfoVo);
        } else {
            log.info("검증 실패 시 : 종료");
        }
        return null;
    }

    @Transactional
    @Override
    public void cancelPay(RequestCancelVo requestCancelVo) {
        OrderBaseVo orderBaseVo = paymentMapper.getOpPayPointInfo(requestCancelVo);
        paymentTrxMapper.updateOpPayInfoPointCancel(requestCancelVo);
        insertCancelDataOpPayInfo(requestCancelVo);
    }

    @Override
    public void netCancel(RequestNetCancelVo requestNetCancelVo) {
        log.info("결제 : 포인트 망취소 서비스 시작");
        log.info("승인 취소 IF 전문 생성");
        log.info("승인 취소 요청 이력 저장(망취소)");
        log.info("승인 취소 IF");
        log.info("승인 취소 요청 결과 이력(망취소) 업데이트");
        log.info("결제 : 포인트 망취소 서비스 종료");
    }

    @Transactional
    public void insertApproveDataOpPayInfo(OrderInfoVo orderInfoVo, PayInfoVo payInfoVo) {
        OpPayInfo opPayInfo = OpPayInfo.builder()
                .ordNo(orderInfoVo.getOrdNo())
                .payMnCd(OPT0009.POINT.getType())
                .payCcd(OPT0010.PAYMENT.getType())
                .payPrgsScd(OPT0011.PAYMENT_COMPLETE.getType())
                .payAmt(payInfoVo.getPayAmount())
                .cnclAmt(0L)
                .rfndAvlAmt(payInfoVo.getPayAmount())
                .build();

        paymentTrxMapper.insertOpPayInfoPointApprove(opPayInfo);
    }

    @Transactional
    public void insertCancelDataOpPayInfo(RequestCancelVo requestCancelVo) {
        OpPayInfo opPayInfo = OpPayInfo.builder()
                .ordNo(requestCancelVo.getOrdNo())
                .payMnCd(OPT0009.POINT.getType())
                .payCcd(OPT0010.CANCEL.getType())
                .payPrgsScd(OPT0011.REFUND_COMPLETE.getType())
                .payAmt(requestCancelVo.getCnclAmt())
                .cnclAmt(0L)
                .rfndAvlAmt(0L)
                .build();

        paymentTrxMapper.insertOpPayInfoPointApprove(opPayInfo);
    }
}
