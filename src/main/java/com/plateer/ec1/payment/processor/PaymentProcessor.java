package com.plateer.ec1.payment.processor;

import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import com.plateer.ec1.payment.vo.request.RequestContextVo;
import com.plateer.ec1.payment.vo.response.ResponseContextVo;
import com.plateer.ec1.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentProcessor {


    //이번 프로젝트에서는 승인 요청 결과 이력은 따로 DB에 업데이트 하지 않으므로, 임시로 log 구현
    public void doPaymentProcess(OrderInfoVo orderInfoVo, PayInfoVo payInfoVo) {
        RequestContextVo requestContextVo = new RequestContextVo();
        ResponseContextVo responseContextVo = requestContextVo.createContext(orderInfoVo, payInfoVo);
        boolean value = Constants.INICIS_SUCCESS_RESULT_CODE.equals(responseContextVo.getResultCode());
        if (value) {
            log.info("승인 요청 결과 성공 이력 업데이트 : " + responseContextVo);
        } else {
            log.info("승인 요청 결과 실패 이력 업데이트 : " + responseContextVo);
        }
    }
}
