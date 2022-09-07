package com.plateer.ec1.claim;

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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
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
        orderClaimInfoVo.setGoodsNo("P001");
        orderClaimInfoVo.setItemNo("1");

        List<OrderClaimInfoVo> orderClaimInfoVoList = new ArrayList<>();
        orderClaimInfoVoList.add(orderClaimInfoVo);

        List<DeliveryInfoVo> deliveryInfoVoList = new ArrayList<>();

        requestClaimVo = RequestClaimVo
                .builder()
                .orderNo("O220826001000008")
                .processorType("20")
                .orderClaimInfoVoList(orderClaimInfoVoList)
                .deliveryInfoVoList(deliveryInfoVoList)
                .prodAmt(1000L)
                .rfndAmt(1000L)
                .dlvAmt(1000L)
                .build();
    }

    @Test
    @DisplayName("1. ECoupon 취소접수 테스트")
    void eCouponCancelAcceptTest() throws Exception {
        String jsonData = objectMapper.writeValueAsString(requestClaimVo);
        mockMvc.perform(
                        post("/api/claim")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(String.valueOf(jsonData)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("2. 반품접수 테스트")
    void returnAcceptTest() throws Exception {
        requestClaimVo.setProcessorType("60");
        String jsonData = objectMapper.writeValueAsString(requestClaimVo);
        mockMvc.perform(
                        post("/api/claim")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(String.valueOf(jsonData)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("3. 반품철회 테스트")
    void returnWithdrawalTest() throws Exception {
        requestClaimVo.setProcessorType("70");
        String jsonData = objectMapper.writeValueAsString(requestClaimVo);
        mockMvc.perform(
                        post("/api/claim")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(String.valueOf(jsonData)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("4. 교환접수 테스트")
    void exchangeAcceptTest() throws Exception {
        requestClaimVo.setProcessorType("40");
        String jsonData = objectMapper.writeValueAsString(requestClaimVo);
        mockMvc.perform(
                        post("/api/claim")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(String.valueOf(jsonData)))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
