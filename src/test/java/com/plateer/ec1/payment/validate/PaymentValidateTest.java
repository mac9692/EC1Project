package com.plateer.ec1.payment.validate;

import com.plateer.ec1.payment.vo.request.RequestCancelVo;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(value = MethodOrderer.DisplayName.class)
public class PaymentValidateTest {

    static ValidatorFactory validatorFactory;
    static Validator validator;
    RequestCancelVo requestCancelVo;

    @BeforeAll
    static void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @BeforeEach
    void init() {
        requestCancelVo = RequestCancelVo
                .builder()
                .paymentType("Test")
                .ordNo("Test")
                .clmNo(1L)
                .cnclAmt(1L)
                .build();
    }

    @ParameterizedTest(name = "{index} : {displayName} - {0}")
    @NullAndEmptySource
    @DisplayName("1-1. RequestCancelVo paymentType Null, Empty 테스트")
    void requestCancelVo_paymentType_test(String message) {
        requestCancelVo.setPaymentType(message);
        Set<ConstraintViolation<RequestCancelVo>> violations = validator.validate(requestCancelVo);
        assertAll(
                () -> assertThat(violations).isNotEmpty(),
                () -> assertEquals(1, violations.size()),
                () -> assertEquals("paymentType 은 Null, \"\", \" \" 입력이 불가능합니다.", violations.iterator().next().getMessage())
        );
    }
}
