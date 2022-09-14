package com.plateer.ec1.order.validate;

import com.plateer.ec1.common.code.order.OPT0001;
import com.plateer.ec1.common.code.order.OPT0002;
import com.plateer.ec1.common.code.promotion.PRM0004;
import com.plateer.ec1.order.vo.*;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import com.plateer.ec1.payment.enums.PaymentType;
import com.plateer.ec1.payment.vo.PayInfoVo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
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
public class OrderBasicValidateTest {

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
    @DisplayName("1-1. OrderRequestVo 주문번호 Null")
    void orderRequestOrdNoNullTest() {
        requestOrderVo.setOrderNo(null);
        Set<ConstraintViolation<RequestOrderVo>> violations = validator.validate(requestOrderVo);
        assertEquals(1, violations.size());
        assertEquals("orderNo 는 Null, \"\", \" \" 입력이 불가능합니다.", violations.iterator().next().getMessage());
    }

    @Test
    @DisplayName("1-2. OrderRequestVo 주문기본 Null")
    void orderRequestOrderVoNullTest() {
        requestOrderVo.setOrderVo(null);
        Set<ConstraintViolation<RequestOrderVo>> violations = validator.validate(requestOrderVo);
        assertEquals(1, violations.size());
        assertEquals("orderVo 는 Null 입력이 불가능합니다.", violations.iterator().next().getMessage());
    }

    @Test
    @DisplayName("1-3. OrderRequestVo 주문상품 Null")
    void orderRequestOrderGoodsVoListNullTest() {
        requestOrderVo.setOrderGoodsVoList(null);
        Set<ConstraintViolation<RequestOrderVo>> violations = validator.validate(requestOrderVo);
        assertEquals(1, violations.size());
        assertEquals("orderGoodsVoList 는 Null 입력이 불가능합니다.", violations.iterator().next().getMessage());
    }

    @Test
    @DisplayName("1-4. OrderRequestVo 주문혜택 Null")
    void orderRequestOrderBenefitVoListNullTest() {
        requestOrderVo.setOrderBenefitVoList(null);
        Set<ConstraintViolation<RequestOrderVo>> violations = validator.validate(requestOrderVo);
        assertEquals(1, violations.size());
        assertEquals("orderBenefitVoList 는 Null 입력이 불가능합니다.", violations.iterator().next().getMessage());
    }

    @Test
    @DisplayName("1-5. OrderRequestVo 배송지정보 Null")
    void orderRequestDeliveryAddressVoListNullTest() {
        requestOrderVo.setDeliveryAddressVoList(null);
        Set<ConstraintViolation<RequestOrderVo>> violations = validator.validate(requestOrderVo);
        assertEquals(1, violations.size());
        assertEquals("deliveryAddressVoList 는 Null 입력이 불가능합니다.", violations.iterator().next().getMessage());
    }

    @Test
    @DisplayName("1-6. OrderRequestVo 결제정보 Null")
    void orderRequestPayInfoVoListNullTest() {
        requestOrderVo.setPayInfoVoList(null);
        Set<ConstraintViolation<RequestOrderVo>> violations = validator.validate(requestOrderVo);
        assertEquals(1, violations.size());
        assertEquals("payInfoVo 는 Null 입력이 불가능합니다.", violations.iterator().next().getMessage());
    }

    @Test
    @DisplayName("1-7. OrderRequestVo OrderType Null")
    void orderRequestOrderTypeListNullTest() {
        requestOrderVo.setOrderType(null);
        Set<ConstraintViolation<RequestOrderVo>> violations = validator.validate(requestOrderVo);
        assertEquals(1, violations.size());
        assertEquals("orderType 는 Null 입력이 불가능합니다.", violations.iterator().next().getMessage());
    }

    @Test
    @DisplayName("1-8. OrderRequestVo SystemType Null")
    void orderRequestSystemTypeNullTest() {
        requestOrderVo.setSystemType(null);
        Set<ConstraintViolation<RequestOrderVo>> violations = validator.validate(requestOrderVo);
        assertEquals(1, violations.size());
        assertEquals("systemType 는 Null 입력이 불가능합니다.", violations.iterator().next().getMessage());
    }

    @Test
    @DisplayName("1-9. OrderRequestVo.OrderVo MbrNo Null")
    void orderRequestMbrNoNullTest() {
        requestOrderVo.getOrderVo().setMbrNo(null);
        Set<ConstraintViolation<RequestOrderVo>> violations = validator.validate(requestOrderVo);
        assertEquals(1, violations.size());
        assertEquals("mbrNo 는 Null, \"\", \" \" 입력이 불가능합니다.", violations.iterator().next().getMessage());
    }

    @Test
    @DisplayName("2-1. OrderRequestVo.OrderVo OrdSellNo Null")
    void orderRequestOrdSellNoNullTest() {
        requestOrderVo.getOrderVo().setOrdSellNo(null);
        Set<ConstraintViolation<RequestOrderVo>> violations = validator.validate(requestOrderVo);
        assertEquals(1, violations.size());
        assertEquals("ordSellNo 는 Null, \"\", \" \" 입력이 불가능합니다.", violations.iterator().next().getMessage());
    }

    @Test
    @DisplayName("2-2. OrderRequestVo.OrderVo OrdAddr Null")
    void orderRequestOrdAddrNullTest() {
        requestOrderVo.getOrderVo().setOrdAddr(null);
        Set<ConstraintViolation<RequestOrderVo>> violations = validator.validate(requestOrderVo);
        assertEquals(1, violations.size());
        assertEquals("ordAddr 는 Null, \"\", \" \" 입력이 불가능합니다.", violations.iterator().next().getMessage());
    }

    @Test
    @DisplayName("2-3. OrderRequestVo.OrderVo OrdAddrDtl Null")
    void orderRequestOrdAddrDtlNullTest() {
        requestOrderVo.getOrderVo().setOrdAddrDtl(null);
        Set<ConstraintViolation<RequestOrderVo>> violations = validator.validate(requestOrderVo);
        assertEquals(1, violations.size());
        assertEquals("ordAddrDtl 는 Null, \"\", \" \" 입력이 불가능합니다.", violations.iterator().next().getMessage());;
    }

    @Test
    @DisplayName("2-4. 주문기본정보-주문수량 0개 이하 여부")
    void orderRequestOrderCountMinTest() {
        requestOrderVo.getOrderGoodsVoList().get(0).setOrderCount(0);
        Set<ConstraintViolation<RequestOrderVo>> violations = validator.validate(requestOrderVo);
        assertEquals(1, violations.size());
        assertEquals("주문 수량 개수는 0개 이상으로 입력하세요.", violations.iterator().next().getMessage());
    }

    @Test
    @DisplayName("2-5. 주문기본정보-주문 상품유무")
    void orderRequestPayInfoVoRfndBnkCkTest() {
        requestOrderVo.getPayInfoVoList().get(0).setRfndBnkCk("05");
        Set<ConstraintViolation<RequestOrderVo>> violations = validator.validate(requestOrderVo);
        assertEquals(1, violations.size());
        assertEquals("orderBenefitVoList 는 Null 입력이 불가능합니다.", violations.iterator().next().getMessage());
    }
}
