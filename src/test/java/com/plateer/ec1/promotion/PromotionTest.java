package com.plateer.ec1.promotion;

import com.plateer.ec1.product.vo.ProductVo;
import com.plateer.ec1.promotion.vo.ProductCouponVo;
import com.plateer.ec1.promotion.controller.CouponController;
import com.plateer.ec1.promotion.controller.PointController;
import com.plateer.ec1.promotion.controller.PromotionController;
import com.plateer.ec1.promotion.service.CouponService;
import com.plateer.ec1.promotion.vo.request.RequestPromotionVo;
import com.plateer.ec1.promotion.vo.response.BaseResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
@TestMethodOrder(value = MethodOrderer.DisplayName.class)
public class PromotionTest {

    @Autowired
    PromotionController promotionController;

    @Autowired
    CouponController couponController;

    @Autowired
    PointController pointController;

    @Autowired
    CouponService couponService;

    @Test
    @DisplayName("1-1. 쿠폰 다운로드 테스트 - 성공 케이스")
    void downloadCouponTest() {
//        RequestPromotionVo requestPromotionVo = new RequestPromotionVo();
//        requestPromotionVo.setPrmNo(2L);
//        requestPromotionVo.setMbrNo("test01");
//        couponController.downloadCoupon(requestPromotionVo);
    }

    @Test
    @DisplayName("1-2. 쿠폰 다운로드 테스트 - 실패 케이스 : 총 다운로드 가능 횟수 초과")
    void downloadCouponTest2() {
        RequestPromotionVo requestPromotionVo = new RequestPromotionVo();
//        requestPromotionVo.setPrmNo(6L);
//        requestPromotionVo.setMbrNo("test01");
        couponController.downloadCoupon(requestPromotionVo);
    }

    @Test
    @DisplayName("1-3. 쿠폰 사용 테스트")
    void useCouponTest() {
        RequestPromotionVo requestPromotionVo = new RequestPromotionVo();
//        requestPromotionVo.setPrmNo(2L);
//        requestPromotionVo.setMbrNo("test01");
//        requestPromotionVo.setCpnIssNo(11L);
//        requestPromotionVo.setOrdNo("2020");
        couponController.useCoupon(requestPromotionVo);
    }

    @Test
    @DisplayName("1-4. 쿠폰 취소 테스트")
    void cancelCouponTest() {
        RequestPromotionVo requestPromotionVo = new RequestPromotionVo();
//        requestPromotionVo.setPrmNo(1L);
//        requestPromotionVo.setMbrNo("test01");
//        requestPromotionVo.setCpnIssNo(13L);
//        requestPromotionVo.setOrdNo("213");
        couponController.cancelCoupon(requestPromotionVo);
    }

    @Test
    @DisplayName("2-1. 상품쿠폰할인 계산 테스트")
    void productCouponCalculationTest() {
        RequestPromotionVo requestPromotionVo = new RequestPromotionVo();

        ProductVo productVo1 = ProductVo.builder().goodsNo("P001").goodsNm("라운드반팔티").itemNo("1").salePrc(29900L).prmPrc(29000L).orderCount(2L).orderPrice(58000L).build();
        ProductVo productVo2 = ProductVo.builder().goodsNo("P002").goodsNm("마스크대형").itemNo("1").salePrc(10900L).prmPrc(10250L).orderCount(3L).orderPrice(10250L).build();

        List<ProductVo> productVoList = new ArrayList<>();
        productVoList.add(productVo1);
        productVoList.add(productVo2);

        requestPromotionVo.setMbrNo("test01");
        requestPromotionVo.setProductVoList(productVoList);

        BaseResponseVo baseResponseVo = promotionController.getProductCouponApplyData(requestPromotionVo);
        log.info(String.valueOf(baseResponseVo));
    }


    @Test
    @DisplayName("2-2. 상품쿠폰할인 계산 테스트")
    void productCouponCalculationTest2() {
        RequestPromotionVo requestPromotionVo = new RequestPromotionVo();

        ProductVo productVo1 = ProductVo.builder().goodsNo("P001").goodsNm("라운드반팔티").itemNo("1").salePrc(29900L).prmPrc(29000L).orderCount(1L).orderPrice(29000L).build();
        ProductVo productVo2 = ProductVo.builder().goodsNo("P001").goodsNm("라운드반팔티").itemNo("2").salePrc(29900L).prmPrc(29000L).orderCount(2L).orderPrice(58000L).build();
        ProductVo productVo3 = ProductVo.builder().goodsNo("P002").goodsNm("마스크대형").itemNo("1").salePrc(10900L).prmPrc(10250L).orderCount(2L).orderPrice(20500L).build();
        ProductVo productVo4 = ProductVo.builder().goodsNo("P002").goodsNm("마스크대형").itemNo("2").salePrc(10900L).prmPrc(10250L).orderCount(1L).orderPrice(10250L).build();
        ProductVo productVo5 = ProductVo.builder().goodsNo("P005").goodsNm("브랜드 양말").itemNo("1").salePrc(10000L).prmPrc(9000L).orderCount(1L).orderPrice(9000L).build();
        ProductVo productVo6 = ProductVo.builder().goodsNo("P005").goodsNm("브랜드 양말").itemNo("2").salePrc(10000L).prmPrc(9000L).orderCount(1L).orderPrice(9000L).build();
        ProductVo productVo7 = ProductVo.builder().goodsNo("P005").goodsNm("브랜드 양말").itemNo("3").salePrc(10000L).prmPrc(9000L).orderCount(3L).orderPrice(27000L).build();
        ProductVo productVo8 = ProductVo.builder().goodsNo("P006").goodsNm("명품선글라스").itemNo("0").salePrc(140000L).prmPrc(140000L).orderCount(1L).orderPrice(140000L).build();
        ProductVo productVo9 = ProductVo.builder().goodsNo("P007").goodsNm("차량용 디퓨저").itemNo("1").salePrc(25000L).prmPrc(24000L).orderCount(1L).orderPrice(24000L).build();
        ProductVo productVo10 = ProductVo.builder().goodsNo("P007").goodsNm("차량용 디퓨저").itemNo("2").salePrc(25000L).prmPrc(24000L).orderCount(2L).orderPrice(48000L).build();
        ProductVo productVo11 = ProductVo.builder().goodsNo("P007").goodsNm("차량용 디퓨저").itemNo("3").salePrc(25000L).prmPrc(24000L).orderCount(1L).orderPrice(24000L).build();

        List<ProductVo> productVoList = new ArrayList<>();
        productVoList.add(productVo1);
        productVoList.add(productVo2);
        productVoList.add(productVo3);
        productVoList.add(productVo4);
        productVoList.add(productVo5);
        productVoList.add(productVo6);
        productVoList.add(productVo7);
        productVoList.add(productVo8);
        productVoList.add(productVo9);
        productVoList.add(productVo10);
        productVoList.add(productVo11);

        requestPromotionVo.setMbrNo("test02");
        requestPromotionVo.setProductVoList(productVoList);

        BaseResponseVo baseResponseVo = promotionController.getProductCouponApplyData(requestPromotionVo);
        log.info(String.valueOf(baseResponseVo));

    }

    @Test
    @DisplayName("2-3. 상품쿠폰할인 계산 테스트")
    void productCouponCalculationTest3() {
        RequestPromotionVo requestPromotionVo = new RequestPromotionVo();

        ProductVo productVo1 = ProductVo.builder().goodsNo("P001").goodsNm("라운드반팔티").itemNo("1").salePrc(29900L).prmPrc(29000L).orderCount(1L).orderPrice(29000L).build();
        ProductVo productVo2 = ProductVo.builder().goodsNo("P002").goodsNm("마스크대형").itemNo("1").salePrc(10900L).prmPrc(10250L).orderCount(1L).orderPrice(10250L).build();
        ProductVo productVo3 = ProductVo.builder().goodsNo("P005").goodsNm("브랜드양말").itemNo("1").salePrc(10000L).prmPrc(9000L).orderCount(1L).orderPrice(9000L).build();
        ProductVo productVo4 = ProductVo.builder().goodsNo("P006").goodsNm("명품선글라스").itemNo("0").salePrc(140000L).prmPrc(140000L).orderCount(1L).orderPrice(140000L).build();
        ProductVo productVo5 = ProductVo.builder().goodsNo("P007").goodsNm("차량용 디퓨저").itemNo("1").salePrc(25000L).prmPrc(24000L).orderCount(1L).orderPrice(24000L).build();

        List<ProductVo> productVoList = new ArrayList<>();
        productVoList.add(productVo1);
        productVoList.add(productVo2);
        productVoList.add(productVo3);
        productVoList.add(productVo4);
        productVoList.add(productVo5);

        requestPromotionVo.setMbrNo("test03");
        requestPromotionVo.setProductVoList(productVoList);

        BaseResponseVo baseResponseVo = promotionController.getProductCouponApplyData(requestPromotionVo);
        log.info(String.valueOf(baseResponseVo));
    }

    @Test
    @DisplayName("3.1 장바구니쿠폰할인 계산 테스트")
    void cartCouponCalculationTest() {
        RequestPromotionVo requestPromotionVo = new RequestPromotionVo();
        ProductVo productVo1 = ProductVo.builder().goodsNo("P001").goodsNm("라운드반팔티").itemNo("1").salePrc(29900L).prmPrc(29000L).orderCount(2L).orderPrice(58000L).build();
        ProductVo productVo2 = ProductVo.builder().goodsNo("P002").goodsNm("마스크대형").itemNo("1").salePrc(10900L).prmPrc(10250L).orderCount(3L).orderPrice(30750L).build();

        List<ProductVo> productVoList = new ArrayList<>();
        productVoList.add(productVo1);
        productVoList.add(productVo2);

        requestPromotionVo.setMbrNo("test01");
        requestPromotionVo.setProductVoList(productVoList);

        BaseResponseVo baseResponseVo = promotionController.getCartCouponApplyData(requestPromotionVo);
        System.out.println(baseResponseVo);
    }

    @Test
    @DisplayName("3.2 장바구니쿠폰할인 계산 테스트")
    void cartCouponCalculationTest2() {
        RequestPromotionVo requestPromotionVo = new RequestPromotionVo();

        ProductVo productVo1 = ProductVo.builder().goodsNo("P001").goodsNm("라운드반팔티").itemNo("1").salePrc(29900L).prmPrc(29000L).orderCount(1L).orderPrice(29000L).build();
        ProductVo productVo2 = ProductVo.builder().goodsNo("P001").goodsNm("라운드반팔티").itemNo("2").salePrc(29900L).prmPrc(29000L).orderCount(2L).orderPrice(58000L).build();
        ProductVo productVo3 = ProductVo.builder().goodsNo("P002").goodsNm("마스크대형").itemNo("1").salePrc(10900L).prmPrc(10250L).orderCount(2L).orderPrice(20500L).build();
        ProductVo productVo4 = ProductVo.builder().goodsNo("P002").goodsNm("마스크대형").itemNo("2").salePrc(10900L).prmPrc(10250L).orderCount(1L).orderPrice(10250L).build();
        ProductVo productVo5 = ProductVo.builder().goodsNo("P005").goodsNm("브랜드 양말").itemNo("1").salePrc(10000L).prmPrc(9000L).orderCount(1L).orderPrice(9000L).build();
        ProductVo productVo6 = ProductVo.builder().goodsNo("P005").goodsNm("브랜드 양말").itemNo("2").salePrc(10000L).prmPrc(9000L).orderCount(1L).orderPrice(9000L).build();
        ProductVo productVo7 = ProductVo.builder().goodsNo("P005").goodsNm("브랜드 양말").itemNo("3").salePrc(10000L).prmPrc(9000L).orderCount(3L).orderPrice(27000L).build();
        ProductVo productVo8 = ProductVo.builder().goodsNo("P006").goodsNm("명품선글라스").itemNo("0").salePrc(140000L).prmPrc(140000L).orderCount(1L).orderPrice(140000L).build();
        ProductVo productVo9 = ProductVo.builder().goodsNo("P007").goodsNm("차량용 디퓨저").itemNo("1").salePrc(25000L).prmPrc(24000L).orderCount(1L).orderPrice(24000L).build();
        ProductVo productVo10 = ProductVo.builder().goodsNo("P007").goodsNm("차량용 디퓨저").itemNo("2").salePrc(25000L).prmPrc(24000L).orderCount(2L).orderPrice(48000L).build();
        ProductVo productVo11 = ProductVo.builder().goodsNo("P007").goodsNm("차량용 디퓨저").itemNo("3").salePrc(25000L).prmPrc(24000L).orderCount(1L).orderPrice(24000L).build();

        List<ProductVo> productVoList = new ArrayList<>();
        productVoList.add(productVo1);
        productVoList.add(productVo2);
        productVoList.add(productVo3);
        productVoList.add(productVo4);
        productVoList.add(productVo5);
        productVoList.add(productVo6);
        productVoList.add(productVo7);
        productVoList.add(productVo8);
        productVoList.add(productVo9);
        productVoList.add(productVo10);
        productVoList.add(productVo11);

        requestPromotionVo.setMbrNo("test02");
        requestPromotionVo.setProductVoList(productVoList);

        BaseResponseVo baseResponseVo = promotionController.getCartCouponApplyData(requestPromotionVo);
        System.out.println(baseResponseVo);
    }

    @Test
    @DisplayName("3.3 장바구니쿠폰할인 계산 테스트")
    void cartCouponCalculationTest3() {
        RequestPromotionVo requestPromotionVo = new RequestPromotionVo();
        ProductVo productVo1 = ProductVo.builder().goodsNo("P001").goodsNm("라운드반팔티").itemNo("1").salePrc(29900L).prmPrc(29000L).orderCount(1L).orderPrice(29000L).build();
        ProductVo productVo2 = ProductVo.builder().goodsNo("P002").goodsNm("마스크대형").itemNo("1").salePrc(10900L).prmPrc(10250L).orderCount(1L).orderPrice(10250L).build();
        ProductVo productVo3 = ProductVo.builder().goodsNo("P005").goodsNm("브랜드양말").itemNo("1").salePrc(10000L).prmPrc(9000L).orderCount(1L).orderPrice(9000L).build();
        ProductVo productVo4 = ProductVo.builder().goodsNo("P006").goodsNm("명품선글라스").itemNo("0").salePrc(140000L).prmPrc(140000L).orderCount(1L).orderPrice(140000L).build();
        ProductVo productVo5 = ProductVo.builder().goodsNo("P007").goodsNm("차량용 디퓨저").itemNo("1").salePrc(25000L).prmPrc(24000L).orderCount(1L).orderPrice(24000L).build();

        List<ProductVo> productVoList = new ArrayList<>();
        productVoList.add(productVo1);
        productVoList.add(productVo2);
        productVoList.add(productVo3);
        productVoList.add(productVo4);
        productVoList.add(productVo5);

        requestPromotionVo.setMbrNo("test03");
        requestPromotionVo.setProductVoList(productVoList);

        BaseResponseVo baseResponseVo = promotionController.getCartCouponApplyData(requestPromotionVo);
        System.out.println(baseResponseVo);
    }

}
