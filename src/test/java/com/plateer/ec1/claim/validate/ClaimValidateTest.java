package com.plateer.ec1.claim.validate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plateer.ec1.claim.controller.ClaimController;
import com.plateer.ec1.claim.vo.DeliveryInfoVo;
import com.plateer.ec1.claim.vo.OrderClaimInfoVo;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestMethodOrder(value = MethodOrderer.DisplayName.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClaimValidateTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ClaimController claimController;

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
        orderClaimInfoVo.setGoodsNo("P001");

        List<OrderClaimInfoVo> orderClaimInfoVoList = new ArrayList<>();
        orderClaimInfoVoList.add(orderClaimInfoVo);

        List<DeliveryInfoVo> deliveryInfoVoList = new ArrayList<>();

        requestClaimVo = RequestClaimVo
                .builder()
                .orderNo("O220812091000004")
                .creatorType("10")
                .processorType("10")
                .orderClaimInfoVoList(orderClaimInfoVoList)
                .deliveryInfoVoList(deliveryInfoVoList)
                .prodAmt(1000L)
                .rfndAmt(1000L)
                .dlvAmt(1000L)
                .build();
    }

    @Test
    @DisplayName("1-1. 상품 존재여부 테스트")
    void gccTest() throws Exception {
        List<OrderClaimInfoVo> orderClaimInfoVoList = requestClaimVo.getOrderClaimInfoVoList();
        orderClaimInfoVoList.get(0).setGoodsNo("P");    //존재하지 않는 상품 번호 작성 후 테스트 진행
        String jsonData = objectMapper.writeValueAsString(requestClaimVo);
        mockMvc.perform(
                        post("/api/claim")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(String.valueOf(jsonData)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("2-1. requestClaimVo 주문번호 NotBlank 테스트(null)")
    void orderRequestOrdNoNullTest() {
        requestClaimVo.setOrderNo(null);
        Set<ConstraintViolation<RequestClaimVo>> violations = validator.validate(requestClaimVo);
        assertEquals(1, violations.size());
        assertEquals("orderNo 는 Null, \"\", \" \" 입력이 불가능합니다.", violations.iterator().next().getMessage());
    }

    @Test
    @DisplayName("2-2. requestClaimVo 주문번호 NotBlank 테스트(null)")
    void orderRequestOrdNoBlankTest() {
        requestClaimVo.setOrderNo("");
        Set<ConstraintViolation<RequestClaimVo>> violations = validator.validate(requestClaimVo);
        assertEquals(1, violations.size());
        assertEquals("orderNo 는 Null, \"\", \" \" 입력이 불가능합니다.", violations.iterator().next().getMessage());
    }

    @Test
    @DisplayName("2-3. requestClaimVo 주문번호 NotBlank 테스트(null)")
    void orderRequestOrdNoSpaceTest() {
        requestClaimVo.setOrderNo(" ");
        Set<ConstraintViolation<RequestClaimVo>> violations = validator.validate(requestClaimVo);
        assertEquals(1, violations.size());
        assertEquals("orderNo 는 Null, \"\", \" \" 입력이 불가능합니다.", violations.iterator().next().getMessage());
    }
}
