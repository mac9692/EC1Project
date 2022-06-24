package com.plateer.ec1.claim;

import com.plateer.ec1.claim.controller.ClaimController;
import com.plateer.ec1.claim.enums.CreatorType;
import com.plateer.ec1.claim.enums.ProcessorType;
import com.plateer.ec1.claim.vo.Claim;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
@TestMethodOrder(value = MethodOrderer.DisplayName.class)
public class ClaimTest {

    @Autowired
    ClaimController claimController;

    @Test
    @DisplayName("1. E 쿠폰 취소 완료 테스트")
    void gccTest() {
        log.info("1. E 쿠폰 취소 완료 테스트 시작");
        Claim claim = new Claim();
        claim.setProcessorType(ProcessorType.COMPLETE);
        claim.setCreatorType(CreatorType.ECOUPONCANCELCOMPLETE);
        claimController.claim(claim);
        log.info("1. E 쿠폰 취소 완료 테스트 종료");
    }

    @Test
    @DisplayName("2. E 쿠폰 취소 접수 테스트")
    void mcaTest() {
        log.info("2. E 쿠폰 취소 접수 시작");
        Claim claim = new Claim();
        claim.setProcessorType(ProcessorType.ACCEPT_WITHDRAWAL);
        claim.setCreatorType(CreatorType.ECOUPONCANCELACCEPT);
        claimController.claim(claim);
        log.info("2. E 쿠폰 취소 접수 종료");
    }
}
