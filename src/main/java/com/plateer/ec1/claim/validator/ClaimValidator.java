package com.plateer.ec1.claim.validator;

import com.plateer.ec1.claim.vo.Claim;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ClaimValidator {

    public void isValidStatus(Claim claim) {
        log.info("검증 시작 : 상태 검증");
    }

    public void isValidAmount(Claim claim) {
        log.info("검증 시작 : 금액 검증");
    }

    public void verifyAmount(Claim claim) {
        log.info("검증 시작 : 재고 검증");
    }
}
