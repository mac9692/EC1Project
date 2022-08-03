package com.plateer.ec1.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plateer.ec1.common.code.order.OPT0001;
import com.plateer.ec1.common.code.order.OPT0002;
import com.plateer.ec1.common.code.promotion.PRM0004;
import com.plateer.ec1.order.enums.AfterStrategyType;
import com.plateer.ec1.order.enums.DataStrategyType;
import com.plateer.ec1.order.vo.*;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestMethodOrder(value = MethodOrderer.DisplayName.class)
@AutoConfigureMockMvc
@SpringBootTest
public class OrderValidateTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    RequestOrderVo requestOrderVo;

    @BeforeEach
    void init() {
        OrderVo orderVo = OrderVo
                .builder()
                .mbrNo("test01")
                .ordTpCd(OPT0001.GENERAL.getType())
                .ordSysCcd(OPT0002.FO.getType())
                .ordNm("홍길동")
                .ordSellNo("01036349692")
                .ordAddr("송파구 문정")
                .ordAddrDtl("문정역")
                .build();

        ProductBenefitVo productBenefitVo = ProductBenefitVo
                .builder()
                .prmNo(1L)
                .cpnKndCd(PRM0004.PRODUCT_COUPON.getType())
                .cpnIssNo(1L)
                .degrCcd(1)
                .build();

        List<ProductBenefitVo> productBenefitVoList = new ArrayList<>();
        productBenefitVoList.add(productBenefitVo);

        OrderGoodsVo orderGoodsVo = OrderGoodsVo
                .builder()
                .ordGoodsNo("P111")
                .ordItemNo("I111")
                .goodsSellTpCd("10")
                .orderCount(1L)
                .productBenefitVoList(productBenefitVoList)
                .build();

        List<OrderGoodsVo> orderGoodsVoList = new ArrayList<>();
        orderGoodsVoList.add(orderGoodsVo);

        OrderBenefitProductVo orderBenefitProductVo = new OrderBenefitProductVo();
        orderBenefitProductVo.setOrdGoodsNo("P111");
        orderBenefitProductVo.setOrdItemNo("I111");

        List<OrderBenefitProductVo> orderBenefitProductVoList = new ArrayList<>();
        orderBenefitProductVoList.add(orderBenefitProductVo);

        OrderBenefitVo orderBenefitVo = OrderBenefitVo
                .builder()
                .prmNo(2L)
                .cpnKndCd(PRM0004.PRODUCT_COUPON.getType())
                .cpnIssNo(2L)
                .degrCcd(3)
                .orderBenefitProductVoList(orderBenefitProductVoList)
                .build();

        List<OrderBenefitVo> orderBenefitVoList = new ArrayList<>();
        orderBenefitVoList.add(orderBenefitVo);

        ProductInfoVo productInfoVo = new ProductInfoVo();
        productInfoVo.setOrdGoodsNo("1");
        productInfoVo.setOrdItemNo("1");

        List<ProductInfoVo> productInfoVoList = new ArrayList<>();
        productInfoVoList.add(productInfoVo);

        CombinedDeliveryVo combinedDeliveryVo = new CombinedDeliveryVo();
        combinedDeliveryVo.setCombinedDeliveryNo(1L);
        combinedDeliveryVo.setProductInfoVoList(productInfoVoList);

        List<CombinedDeliveryVo> combinedDeliveryVoList = new ArrayList<>();
        combinedDeliveryVoList.add(combinedDeliveryVo);

        DeliveryAddressVo deliveryAddressVo = DeliveryAddressVo
                .builder()
                .dvpSeq(1)
                .rmtiNm("박진성")
                .rmtiHpNo("01036349692")
                .rmtiAddr("송파구 문정")
                .rmtiAddrDtl("문정역")
                .combinedDeliveryVoList(combinedDeliveryVoList)
                .build();

        List<DeliveryAddressVo> deliveryAddressVoList = new ArrayList<>();
        deliveryAddressVoList.add(deliveryAddressVo);

        PayInfoVo payInfoVo = new PayInfoVo();

        requestOrderVo = RequestOrderVo
                .builder()
                .orderNo("0202")
                .orderVo(orderVo)
                .orderGoodsVoList(orderGoodsVoList)
                .orderBenefitVoList(orderBenefitVoList)
                .deliveryAddressVoList(deliveryAddressVoList)
                .payInfoVo(payInfoVo)
                .orderType(DataStrategyType.GENERAL)
                .systemType(AfterStrategyType.FO)
                .build();

    }

    @Test
    @DisplayName("1. OrderRequestVo 주문번호 Null")
    void orderRequestOrdNoNullTest() throws Exception {
        requestOrderVo.setOrderNo(null);
        String jsonData = objectMapper.writeValueAsString(requestOrderVo);

        mockMvc.perform(post("/order")
                .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(jsonData)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("2. OrderRequestVo 주문기본 Null")
    void orderRequestOrderVoNullTest() throws Exception {
        requestOrderVo.setOrderVo(null);
        String jsonData = objectMapper.writeValueAsString(requestOrderVo);

        mockMvc.perform(post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(jsonData)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("3. OrderRequestVo 주문상품 Null")
    void orderRequestOrderGoodsVoListNullTest() throws Exception {
        requestOrderVo.setOrderGoodsVoList(null);
        String jsonData = objectMapper.writeValueAsString(requestOrderVo);

        mockMvc.perform(post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(jsonData)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("4. OrderRequestVo 주문혜택 Null")
    void orderRequestOrderBenefitVoListNullTest() throws Exception {
        requestOrderVo.setOrderBenefitVoList(null);
        String jsonData = objectMapper.writeValueAsString(requestOrderVo);

        mockMvc.perform(post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(jsonData)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("5. OrderRequestVo 배송지정보 Null")
    void orderRequestDeliveryAddressVoListNullTest() throws Exception {
        requestOrderVo.setDeliveryAddressVoList(null);
        String jsonData = objectMapper.writeValueAsString(requestOrderVo);

        mockMvc.perform(post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(jsonData)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("6. OrderRequestVo 결제정보 Null")
    void orderRequestPayInfoVoListNullTest() throws Exception {
        requestOrderVo.setPayInfoVo(null);
        String jsonData = objectMapper.writeValueAsString(requestOrderVo);

        mockMvc.perform(post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(jsonData)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("7. OrderRequestVo OrderType Null")
    void orderRequestOrderTypeListNullTest() throws Exception {
        requestOrderVo.setOrderType(null);
        String jsonData = objectMapper.writeValueAsString(requestOrderVo);

        mockMvc.perform(post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(jsonData)))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("8. OrderRequestVo SystemType Null")
    void orderRequestSystemTypeNullTest() throws Exception {
        requestOrderVo.setSystemType(null);
        String jsonData = objectMapper.writeValueAsString(requestOrderVo);

        mockMvc.perform(post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(jsonData)))
                .andExpect(status().isBadRequest());
    }
}
