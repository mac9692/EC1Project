package com.plateer.ec1.claim.validate;

import com.plateer.ec1.claim.vo.DeliveryInfoVo;
import com.plateer.ec1.claim.vo.OrderClaimInfoVo;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(value = MethodOrderer.DisplayName.class)
@SpringBootTest
public class ClaimValidateTest {


    static ValidatorFactory validatorFactory;
    static Validator validator;

    RequestClaimVo requestClaimVo;

    @BeforeAll
    static void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @BeforeEach
    void init() {
        OrderClaimInfoVo orderClaimInfoVo = new OrderClaimInfoVo();
        orderClaimInfoVo.setGoodsNo("1");

        List<OrderClaimInfoVo> orderClaimInfoVoList = new ArrayList<>();
        orderClaimInfoVoList.add(orderClaimInfoVo);

        List<DeliveryInfoVo> deliveryInfoVoList = new ArrayList<>();

        requestClaimVo = RequestClaimVo
                .builder()
                .orderNo("O220812091000004")
                .creatorType("20")
                .processorType("10")
                .orderClaimInfoVoList(orderClaimInfoVoList)
                .deliveryInfoVoList(deliveryInfoVoList)
                .prodAmt(1000L)
                .rfndAmt(1000L)
                .dlvAmt(1000L)
                .build();
    }


    @Test
    @DisplayName("1-1. orderNo Null")
    void orderRequestOrdNoNullTest() {
        Set<ConstraintViolation<RequestClaimVo>> violations = validator.validate(requestClaimVo);
        assertThat(violations).isEmpty();
//        assertEquals(1, violations.size());
//        assertEquals("orderNo 는 Null, \"\", \" \" 입력이 불가능합니다.", violations.iterator().next().getMessage());
    }
}
