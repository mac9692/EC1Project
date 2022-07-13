package com.plateer.ec1.payment.service.impl;

import com.plateer.ec1.common.code.order.OPT0009;
import com.plateer.ec1.common.code.order.OPT0010;
import com.plateer.ec1.common.code.order.OPT0011;
import com.plateer.ec1.common.model.order.OpPayInfo;
import com.plateer.ec1.payment.enums.PaymentType;
import com.plateer.ec1.payment.mapper.PaymentTrxMapper;
import com.plateer.ec1.payment.service.PaymentService;
import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.PayApproveResponseVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import com.plateer.ec1.payment.vo.request.RequestCancelVo;
import com.plateer.ec1.payment.vo.request.RequestContextVo;
import com.plateer.ec1.payment.vo.request.RequestNetCancelVo;
import com.plateer.ec1.payment.vo.response.ResponseContextVo;
import com.plateer.ec1.util.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Primary
@RequiredArgsConstructor
public class Inicis implements PaymentService {

    private final PaymentTrxMapper paymentTrxMapper;

    @Override
    public PaymentType getType() {
        return PaymentType.INICIS;
    }


    //PG 사 결제 인터페이스에서 인증을 거치는 과정
    //PG 사 인증 return 값을 받아서 validate 진행을 하지만 현재 배제하고 무조건 true 반환
    @Override
    public boolean validatePGAuth(PayInfoVo payInfoVo) {
        return true;
    }

    @Override
    @Transactional
    public List<PayApproveResponseVo> approvePay(OrderInfoVo orderInfoVo, PayInfoVo payInfoVo) {
        if (validatePGAuth(payInfoVo)) {
            RequestContextVo requestContextVo = new RequestContextVo();
            ResponseContextVo responseContextVo = requestContextVo.createContext(orderInfoVo, payInfoVo);
            boolean value = Constants.INICIS_SUCCESS_RESULT_CODE.equals(responseContextVo.getResultCode());
            if (value) {
                insertOpPayInfo(responseContextVo, orderInfoVo, payInfoVo);
                log.info("승인 요청 결과 성공 이력 업데이트");
            } else {
                log.info("승인 요청 결과 실패 이력 업데이트");
            }
        } else {
            log.info("검증 실패 시 : 종료");
        }
        return null;
    }

    @Override
    public void cancelPay(RequestCancelVo requestCancelVo) {
        log.info("결제사 : 이니시스 결제 취소 서비스 시작");
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
        log.info("결제사 : 이니시스 결제 취소 서비스 종료");
    }

    @Override
    public void netCancel(RequestNetCancelVo requestNetCancelVo) {
        log.info("결제사 : 이니시스 망취소 서비스 시작");
        log.info("승인 취소 IF 전문 생성");
        log.info("승인 취소 요청 이력 저장(망취소)");
        log.info("승인 취소 IF");
        log.info("승인 취소 요청 결과 이력(망취소) 업데이트");
        log.info("결제사 : 이니시스 망취소 서비스 종료");
    }

    @Transactional
    public void insertOpPayInfo(ResponseContextVo responseContextVo, OrderInfoVo orderInfoVo, PayInfoVo payInfoVo) {
        OpPayInfo opPayInfo = OpPayInfo.builder()
                .payNo(Constants.PAY_NO_S + responseContextVo.getValidDate() + (int)(Math.random()*100))
                .ordNo(orderInfoVo.getOrdNo())
                .payMnCd(OPT0009.VIRTUAL_ACCOUNT.getType())
                .payCcd(OPT0010.PAYMENT.getType())
                .payPrgsScd(OPT0011.PAYMENT_REQUEST.getType())
                .payAmt(Long.valueOf(responseContextVo.getPrice()))
                .cnclAmt(0L)
                .rfndAvlAmt(0L)
                .trsnId(responseContextVo.getTid())
                .vrValDt(responseContextVo.getValidDate())
                .vrValTt(responseContextVo.getValidTime())
                .vrAcct(responseContextVo.getVacct())
                .vrAcctNm(responseContextVo.getVacctName())
                .vrBnkCd(responseContextVo.getVacctBankCode())
                .build();

        paymentTrxMapper.insertOpPayInfo(opPayInfo);
    }
}
