package com.plateer.ec1.claim;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plateer.ec1.claim.controller.ClaimController;
import com.plateer.ec1.claim.vo.DeliveryInfoVo;
import com.plateer.ec1.claim.vo.OrderClaimInfoVo;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import com.plateer.ec1.claim.vo.response.ResponseClaimVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@Slf4j
@TestMethodOrder(value = MethodOrderer.DisplayName.class)
@AutoConfigureMockMvc
public class ClaimTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ClaimController claimController;

    RequestClaimVo requestClaimVo;

    @BeforeEach
    void init() {
        OrderClaimInfoVo orderClaimInfoVo = new OrderClaimInfoVo();
        orderClaimInfoVo.setGoodsNo("P");

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
    @DisplayName("1. E 쿠폰 취소 완료 테스트")
    void gccTest() throws Exception {
        log.info("1. E 쿠폰 취소 완료 테스트 시작");
        String jsonData = objectMapper.writeValueAsString(requestClaimVo);
        mockMvc.perform(
                post("/api/claim")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(jsonData)));

        log.info("1. E 쿠폰 취소 완료 테스트 종료");
    }

    @Test
    @DisplayName("2. E 쿠폰 취소 접수 테스트")
    void mcaTest() {
        log.info("2. E 쿠폰 취소 접수 시작");
//        claimController.claim(requestClaimVo);
        log.info("2. E 쿠폰 취소 접수 종료");
    }
}
