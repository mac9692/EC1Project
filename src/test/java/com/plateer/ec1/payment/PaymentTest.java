package com.plateer.ec1.payment;

import com.plateer.ec1.common.code.order.OPT0013;
import com.plateer.ec1.payment.controller.PaymentController;
import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import com.plateer.ec1.payment.vo.request.RequestApproveCompleteVo;
import com.plateer.ec1.payment.vo.request.RequestCancelVo;
import com.plateer.ec1.payment.vo.request.RequestPaymentVo;
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
public class PaymentTest {

    @Autowired
    PaymentController paymentController;

    @Test
    @DisplayName("1. 이니시스 - 결제 승인 테스트")
    void approveTest() {
        RequestPaymentVo requestPaymentVo = new RequestPaymentVo();
        OrderInfoVo orderInfoVo = OrderInfoVo
                .builder()
                .ordNo("5")
                .buyerName("박진성")
                .buyerEmail("박진성 이메일")
                .goodName("새우깡")
                .moid("192938127892-2328382")
                .storeUrl("https://abc.com")
                .build();

        List<PayInfoVo> payInfoVoList = new ArrayList<>();
        PayInfoVo payInfoVo1 = new PayInfoVo();
        payInfoVo1.setPaymentType("10");
        payInfoVo1.setPayAmount(20000L);
        payInfoVo1.setBankCode(OPT0013.NH.getType());
        payInfoVo1.setDepositorName("박진성");

        payInfoVoList.add(payInfoVo1);

        requestPaymentVo.setOrderInfoVo(orderInfoVo);
        requestPaymentVo.setPayInfoVoList(payInfoVoList);

        paymentController.approve(requestPaymentVo);
    }

    @Test
    @DisplayName("2. 입금 완료 테스트")
    void approveCompleteTest() {
        RequestApproveCompleteVo requestApproveCompleteVo = RequestApproveCompleteVo.builder()
                .no_tid("ININPGVBNKINIpayTest20220714130936873141")
                .no_oid("192938127892-2328382")
                .cd_bank("00000011")
                .cd_deal("00000011")
                .dt_trans("20220714")
                .tm_trans("130936")
                .no_vacct("79015900529638")
                .amt_input(1L)
                .flg_close("0")
                .cl_close("0")
                .type_msg("0200")
                .nm_inputbank("__�\u05FD�Ʈ__")
                .nm_input("ȫ�浿")
                .dt_inputstd("20220714")
                .dt_calculstd("20220714")
                .dt_transbase("20220714")
                .cl_trans("1100")
                .cl_kor("2")
                .dt_cshr(null)
                .tm_cshr(null)
                .no_cshr_appl(null)
                .no_cshr_tid(null)
                .build();
        paymentController.approveComplete(requestApproveCompleteVo);
    }

    @Test
    @DisplayName("3. 이니시스 취소 테스트")
    void cancelTest() {
        RequestCancelVo requestCancelVo = new RequestCancelVo();
        requestCancelVo.setPaymentType("10");
        requestCancelVo.setOrdNo("5");
        requestCancelVo.setClmNo(1L);
        requestCancelVo.setCnclAmt(1L);

        paymentController.cancel(requestCancelVo);
    }

    @Test
    @DisplayName("4. 포인트 - 결제 승인 테스트")
    void approvePointTest() {
        RequestPaymentVo requestPaymentVo = new RequestPaymentVo();
        OrderInfoVo orderInfoVo = OrderInfoVo
                .builder()
                .ordNo("7")
                .buyerName("박진성")
                .buyerEmail("박진성 이메일")
                .goodName("새우깡")
                .moid("192938127892-2328382")
                .storeUrl("https://abc.com")
                .build();

        List<PayInfoVo> payInfoVoList = new ArrayList<>();
        PayInfoVo payInfoVo1 = new PayInfoVo();
        payInfoVo1.setPaymentType("20");
        payInfoVo1.setPayAmount(20000L);
        payInfoVo1.setBankCode(OPT0013.NH.getType());
        payInfoVo1.setDepositorName("박진성");

        payInfoVoList.add(payInfoVo1);

        requestPaymentVo.setOrderInfoVo(orderInfoVo);
        requestPaymentVo.setPayInfoVoList(payInfoVoList);

        paymentController.approve(requestPaymentVo);
    }

    @Test
    @DisplayName("5. 포인트 취소 테스트")
    void cancelPointTest() {
        RequestCancelVo requestCancelVo = new RequestCancelVo();
        requestCancelVo.setPaymentType("20");
        requestCancelVo.setOrdNo("7");
        requestCancelVo.setClmNo(1L);
        requestCancelVo.setCnclAmt(1L);

        paymentController.cancel(requestCancelVo);
    }
}
