package com.plateer.ec1.claim.helper;

import com.plateer.ec1.claim.vo.Claim;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class IFCallHelper {

    public void callRestoreCoupon(Claim claim) {
        log.info("쿠폰 복원 API 호출");
    }

    public void callPaymentIF(Claim claim) {
        log.info("결제 인터페이스 호출");
    }
}
