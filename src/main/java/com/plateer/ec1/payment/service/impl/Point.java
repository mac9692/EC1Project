package com.plateer.ec1.payment.service.impl;

import com.plateer.ec1.payment.enums.PaymentType;
import com.plateer.ec1.payment.service.PaymentService;
import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.PayApproveResponseVo;
import com.plateer.ec1.payment.vo.request.RequestCancelVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import com.plateer.ec1.payment.vo.request.RequestNetCancelVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class Point implements PaymentService {
    @Override
    public PaymentType getType() {
        return PaymentType.POINT;
    }

    @Override
    public boolean validatePGAuth(PayInfoVo payInfo) {
        log.info("결제 : 포인트 인증 성공 여부 검증");
        return true;
    }

    @Override
    public List<PayApproveResponseVo> approvePay(OrderInfoVo orderInfoVo, PayInfoVo payInfoVo) {
        log.info("결제 : 포인트 결제 승인 서비스 시작");
        if (validatePGAuth(payInfoVo)) {
            log.info("검증 성공 시 : 승인 요청 IF 전문 생성");
            log.info("승인 요청 이력 저장");
            log.info("승인 요청 IF 시작");
            log.info("승인 요청 IF 성공 시 : 주문 결제 승인 데이터 저장");
            log.info("승인 요청 IF 실패 시 : 승인 요청 결과 이력 업데이트");
            log.info("승인 요청 결과 이력 업데이트");
        } else {
            log.info("검증 실패 시 : 종료");
        }
        log.info("결제 : 포인트 결제 승인 서비스 종료");
        return null;
    }

    @Override
    public void cancelPay(RequestCancelVo requestCancelVo) {
        log.info("결제 : 포인트 결제 취소 서비스 시작");
        log.info("원 주문결제 데이터 조회 -> 취소 할 완료된 주문 데이터");
        log.info("취소 요청 금액 및 환불 가능 금액 검증");
        log.info("검증 성공 시 : 환불 가능 금액 업데이트");
        log.info("검증 실패 시 : 종료");
        log.info("주문결제 취소 데이터 저장");
        log.info("승인 취소 요청 IF 전문 생성");
        log.info("승인 취소 요청 이력 저장");
        log.info("승인 취소 IF");
        log.info("주문결제 취소 데이터 수정");
        log.info("승인 취소 요청 결과 이력 업데이트");
        log.info("결제 : 포인트 결제 취소 서비스 종료");
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
}
