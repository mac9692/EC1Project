package com.plateer.ec1.springtest;

import com.plateer.ec1.claim.creator.ClaimDataCreator;
import com.plateer.ec1.claim.factory.ClaimDataCreatorFactory;
import com.plateer.ec1.claim.factory.ClaimProcessorFactory;
import com.plateer.ec1.claim.processor.ClaimProcessor;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import com.plateer.ec1.payment.enums.PaymentType;
import com.plateer.ec1.payment.factory.PaymentServiceFactory;
import com.plateer.ec1.payment.service.PaymentService;
import com.plateer.ec1.payment.vo.PayInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@TestMethodOrder(value = MethodOrderer.DisplayName.class)
@SpringBootTest
@Slf4j
public class SpringTest {

    @Autowired
    PaymentServiceFactory paymentServiceFactory;

    @Autowired
    ClaimDataCreatorFactory claimDataCreatorFactory;

    @Autowired
    ClaimProcessorFactory claimProcessorFactory;

    RequestClaimVo requestClaimVo;

    @BeforeEach
    void init() {
        requestClaimVo = RequestClaimVo
                .builder()
                .creatorType("10")
                .processorType("20")
                .build();
    }

    @Test
    @DisplayName("1. 빈 싱글톤 확인 테스트")
    void testBean() {
        log.info("1. 빈 싱글톤 확인 테스트 시작");
        log.info("결제 팩토리 테스트");
        PayInfoVo payInfo = new PayInfoVo();
        payInfo.setPaymentType(PaymentType.POINT);

        PaymentService paymentService1 = paymentServiceFactory.getPaymentService(payInfo.getPaymentType());
        PaymentService paymentService2 = paymentServiceFactory.getPaymentService(payInfo.getPaymentType());


        log.info(String.valueOf(paymentService1));
        log.info(String.valueOf(paymentService2));
        //paymentService1 = paymentService2
        Assertions.assertThat(paymentService1).isSameAs(paymentService2);
        log.info("결제 팩토리 테스트 종료");

        log.info("클레임 팩토리 테스트 시작");
        ClaimProcessor claimProcessor1 = claimProcessorFactory.getClaimProcessor(requestClaimVo.getProcessorType());
        ClaimProcessor claimProcessor2 = claimProcessorFactory.getClaimProcessor(requestClaimVo.getProcessorType());
        ClaimDataCreator claimDataCreator1 = claimDataCreatorFactory.getClaimDataCreator(requestClaimVo.getCreatorType());
        ClaimDataCreator claimDataCreator2 = claimDataCreatorFactory.getClaimDataCreator(requestClaimVo.getCreatorType());
        log.info(String.valueOf(claimProcessor1));
        log.info(String.valueOf(claimProcessor2));
        log.info(String.valueOf(claimDataCreator1));
        log.info(String.valueOf(claimDataCreator2));
        //claimProcessor1 = claimProcessor2
        Assertions.assertThat(claimProcessor1).isSameAs(claimProcessor2);
        //claimDataCreator1 = claimDataCreator2
        Assertions.assertThat(claimDataCreator1).isSameAs(claimDataCreator2);
        log.info("클레임 팩토리 테스트 종료");
        log.info("1. 빈 싱글톤 확인 테스트 종료");
    }
}
