package com.plateer.ec1.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plateer.ec1.common.code.order.OPT0001;
import com.plateer.ec1.common.code.order.OPT0002;
import com.plateer.ec1.common.code.promotion.PRM0004;
import com.plateer.ec1.order.controller.OrderController;
import com.plateer.ec1.order.vo.*;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import com.plateer.ec1.payment.enums.PaymentType;
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

@SpringBootTest
@TestMethodOrder(value = MethodOrderer.DisplayName.class)
@AutoConfigureMockMvc
public class OrderTest {

    @Autowired
    OrderController orderController;

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
                .dcVal(1000L)
                .degrCcd(1)
                .build();

        List<ProductBenefitVo> productBenefitVoList = new ArrayList<>();
        productBenefitVoList.add(productBenefitVo);

        OrderGoodsVo orderGoodsVo = OrderGoodsVo
                .builder()
                .ordGoodsNo("P001")
                .ordItemNo("1")
                .goodsSellTpCd("10")
                .orderCount(1)
                .productBenefitVoList(productBenefitVoList)
                .build();

        List<OrderGoodsVo> orderGoodsVoList = new ArrayList<>();
        orderGoodsVoList.add(orderGoodsVo);

        OrderBenefitProductVo orderBenefitProductVo = new OrderBenefitProductVo();
        orderBenefitProductVo.setOrdSeq(1);
        orderBenefitProductVo.setProcSeq(1);
        orderBenefitProductVo.setOrdGoodsNo("P111");
        orderBenefitProductVo.setAplyAmt(1000L);
        orderBenefitProductVo.setOrdItemNo("I111");

        List<OrderBenefitProductVo> orderBenefitProductVoList = new ArrayList<>();
        orderBenefitProductVoList.add(orderBenefitProductVo);

        OrderBenefitVo orderBenefitVo = OrderBenefitVo
                .builder()
                .prmNo(2L)
                .cpnKndCd(PRM0004.PRODUCT_COUPON.getType())
                .cpnIssNo(2L)
                .ordBnfNo("099")
                .degrCcd(3)
                .ordCnclBnfAmt(1000)
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
        combinedDeliveryVo.setOrderCostNo("3");
        combinedDeliveryVo.setCombinedDeliveryNo(1);
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

        PayInfoVo payInfoVo = PayInfoVo
                .builder()
                .payAmount(19000L)
                .bankCode("04")
                .paymentType(PaymentType.INICIS)
                .depositorName("박진성")
                .rfndBnkCk("04")
                .rfndAcctNo("700102-01-111")
                .rfndAcctOwnNm("박진성")
                .build();

        List<PayInfoVo> payInfoVoList = new ArrayList<>();
        payInfoVoList.add(payInfoVo);

        requestOrderVo = RequestOrderVo
                .builder()
                .orderNo("0202")
                .orderVo(orderVo)
                .orderGoodsVoList(orderGoodsVoList)
                .orderBenefitVoList(orderBenefitVoList)
                .deliveryAddressVoList(deliveryAddressVoList)
                .payInfoVoList(payInfoVoList)
                .orderType("10")
                .systemType("10")
                .build();
    }

    @Test
    @DisplayName("주문하기 전체 로직 TEST")
    void generalOrderOrderTest() throws Exception {
        requestOrderVo.setOrderNo("05");
//        requestOrderVo.setOrderNo(null);
        String jsonData = objectMapper.writeValueAsString(requestOrderVo);

        mockMvc.perform(post("/order")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(jsonData)));
    }
}
