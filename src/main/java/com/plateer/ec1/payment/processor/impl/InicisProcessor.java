package com.plateer.ec1.payment.processor.impl;

import com.plateer.ec1.common.code.order.OPT0011;
import com.plateer.ec1.common.model.order.OpPayInfoModel;
import com.plateer.ec1.payment.enums.PaymentType;
import com.plateer.ec1.payment.mapper.PaymentMapper;
import com.plateer.ec1.payment.mapper.PaymentTrxMapper;
import com.plateer.ec1.payment.processor.PaymentProcessor;
import com.plateer.ec1.payment.vo.OrderBaseVo;
import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.PayApproveResponseVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import com.plateer.ec1.payment.vo.context.FullRefundContextVo;
import com.plateer.ec1.payment.vo.context.PartialRefundContextVo;
import com.plateer.ec1.payment.vo.request.RequestCancelVo;
import com.plateer.ec1.payment.vo.context.ApproveContextVo;
import com.plateer.ec1.payment.vo.response.ResponseApproveVo;
import com.plateer.ec1.payment.vo.response.ResponseFullRefundVo;
import com.plateer.ec1.payment.vo.response.ResponsePartialRefundVo;
import com.plateer.ec1.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
@Primary
@RequiredArgsConstructor
public class InicisProcessor implements PaymentProcessor {

    private final PaymentMapper paymentMapper;
    private final PaymentTrxMapper paymentTrxMapper;

    @Override
    public String getType() {
        return PaymentType.INICIS.getType();
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
            ResponseApproveVo responseApproveVo = approveRequest(orderInfoVo, payInfoVo);
            boolean value = Constants.INICIS_SUCCESS_RESULT_CODE.equals(responseApproveVo.getResultCode());
            if (value) {
                insertApproveDataOpPayInfo(responseApproveVo, orderInfoVo, payInfoVo);
                log.info("승인 요청 결과 성공 이력 업데이트");
            } else {
                log.info("승인 요청 결과 실패 이력 업데이트");
            }
        } else {
            log.info("검증 실패 시 : 종료");
        }
        return null;
    }

    @Transactional
    @Override
    public void cancelPay(RequestCancelVo requestCancelVo) {
        OrderBaseVo orderBaseVo = paymentMapper.getOpPayInfo(requestCancelVo);
        if (OPT0011.PAYMENT_REQUEST.getType().equals(orderBaseVo.getPayPrgsScd())) {
            paymentTrxMapper.updateOpPayInfoCancel(orderBaseVo);
            paymentTrxMapper.insertOpPayInfoCancel(orderBaseVo);
            if (requestCancelVo.getCnclAmt() < orderBaseVo.getPayAmt()) {
                paymentTrxMapper.insertOpPayInfoCancelBefore(orderBaseVo, requestCancelVo);
            }
        } else if (OPT0011.PAYMENT_COMPLETE.getType().equals(orderBaseVo.getPayPrgsScd())) {
            if (requestCancelVo.getCnclAmt().equals(orderBaseVo.getRfndAvlAmt())) {
                ResponseFullRefundVo responseFullRefundVo = fullRefundRequest(orderBaseVo);
            } else if (requestCancelVo.getCnclAmt() > orderBaseVo.getRfndAvlAmt()) {
                ResponsePartialRefundVo responsePartialRefundVo = partialRefundRequest(orderBaseVo, requestCancelVo);
            }
        }
    }

    public ResponseApproveVo approveRequest(OrderInfoVo orderInfoVo, PayInfoVo payInfoVo) {
        ApproveContextVo approveContextVo = new ApproveContextVo();
        HttpEntity<MultiValueMap<String, String>> context = approveContextVo.createContext(orderInfoVo, payInfoVo);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResponseApproveVo> responseEntity = restTemplate.postForEntity(Constants.APPROVE_URL_POST, context, ResponseApproveVo.class);

        return responseEntity.getBody();
    }

    public ResponseFullRefundVo fullRefundRequest(OrderBaseVo orderBaseVo) {
        FullRefundContextVo fullRefundContextVo = new FullRefundContextVo();
        HttpEntity<MultiValueMap<String, String>> context = fullRefundContextVo.createContext(orderBaseVo);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResponseFullRefundVo> responseEntity = restTemplate.postForEntity(Constants.REFUND_URL_POST, context, ResponseFullRefundVo.class);

        return responseEntity.getBody();
    }

    public ResponsePartialRefundVo partialRefundRequest(OrderBaseVo orderBaseVo, RequestCancelVo requestCancelVo) {
        PartialRefundContextVo partialRefundContextVo = new PartialRefundContextVo();
        HttpEntity<MultiValueMap<String, String>> context = partialRefundContextVo.createContext(orderBaseVo, requestCancelVo);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResponsePartialRefundVo> responseEntity = restTemplate.postForEntity(Constants.REFUND_URL_POST, context, ResponsePartialRefundVo.class);

        return responseEntity.getBody();
    }

    @Transactional
    public void insertApproveDataOpPayInfo(ResponseApproveVo responseApproveVo, OrderInfoVo orderInfoVo, PayInfoVo payInfoVo) {
        OpPayInfoModel opPayInfoModel = new OpPayInfoModel().insertInicisApproveDataOpPayInfo(responseApproveVo, orderInfoVo, payInfoVo);
        paymentTrxMapper.insertOpPayInfo(opPayInfoModel);
    }
}
