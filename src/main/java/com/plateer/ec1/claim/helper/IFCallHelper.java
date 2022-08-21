package com.plateer.ec1.claim.helper;

import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class IFCallHelper {

    public void callRestoreCoupon(RequestClaimVo requestClaimVo) {
        log.info("쿠폰 복원 API 호출");
    }

    public void callPaymentIF(RequestClaimVo requestClaimVo) {
        log.info("결제 인터페이스 호출");
    }
}
