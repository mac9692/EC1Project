package com.plateer.ec1.order.validate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plateer.ec1.common.code.order.OPT0001;
import com.plateer.ec1.common.code.order.OPT0002;
import com.plateer.ec1.common.code.promotion.PRM0004;
import com.plateer.ec1.order.enums.AfterStrategyType;
import com.plateer.ec1.order.enums.DataStrategyType;
import com.plateer.ec1.order.vo.*;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import com.plateer.ec1.payment.enums.PaymentType;
import com.plateer.ec1.payment.vo.PayInfoVo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(value = MethodOrderer.DisplayName.class)
@SpringBootTest
public class OrderPayInfoValidateTest {

    static ValidatorFactory validatorFactory;
    static Validator validator;
    RequestOrderVo requestOrderVo;

    @BeforeAll
    static void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

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
                .ordGoodsNo("P111")
                .ordItemNo("I111")
                .goodsSellTpCd("10")
                .orderCount(1)
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
                .paymentType("10")
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
    @DisplayName("1-1. OrderRequestVo.PayInfoVo 환불계좌은행코드 Null 테스트")
    void orderRequestPayInfoVoRfndBnkCkTest() {
        requestOrderVo.getPayInfoVoList().get(0).setRfndBnkCk(null);
        Set<ConstraintViolation<RequestOrderVo>> violations = validator.validate(requestOrderVo);
        assertEquals(1, violations.size());
        assertEquals("환불은행코드는 Null 입력이 불가능합니다.", violations.iterator().next().getMessage());
    }

    @Test
    @DisplayName("1-2. OrderRequestVo.PayInfoVo 환불계좌번호 Null 테스트")
    void orderRequestPayInfoVoRfndAcctNoTest() {
        requestOrderVo.getPayInfoVoList().get(0).setRfndAcctNo(null);
        Set<ConstraintViolation<RequestOrderVo>> violations = validator.validate(requestOrderVo);
        assertEquals(1, violations.size());
        assertEquals("환불은행계좌번호는 Null 입력이 불가능합니다.", violations.iterator().next().getMessage());
    }

    @Test
    @DisplayName("1-3. OrderRequestVo.PayInfoVo 환불계좌예금주명 Null 테스트")
    void orderRequestPayInfoVoRfndAcctOwnNmTest() {
        requestOrderVo.getPayInfoVoList().get(0).setRfndAcctOwnNm(null);
        Set<ConstraintViolation<RequestOrderVo>> violations = validator.validate(requestOrderVo);
        assertEquals(1, violations.size());
        assertEquals("환불은행예금주는 Null 입력이 불가능합니다.", violations.iterator().next().getMessage());
    }
}
