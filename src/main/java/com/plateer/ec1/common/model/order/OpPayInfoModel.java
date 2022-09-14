package com.plateer.ec1.common.model.order;

import com.plateer.ec1.common.code.order.OPT0009;
import com.plateer.ec1.common.code.order.OPT0010;
import com.plateer.ec1.common.code.order.OPT0011;
import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import com.plateer.ec1.payment.vo.request.RequestCancelVo;
import com.plateer.ec1.payment.vo.response.ResponseApproveVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OpPayInfoModel {

    private String payNo;
    private String ordNo;
    private String clmNo;
    private String payMnCd;
    private String payCcd;
    private String payPrgsScd;
    private Long payAmt;
    private Long cnclAmt;
    private Long rfndAvlAmt;
    private String trsnId;
    private Timestamp payCmtDtime;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;
    private String orgPayNo;
    private String vrAcct;
    private String vrAcctNm;
    private String vrBnkCd;
    private String vrValDt;
    private String vrValTt;

    public OpPayInfoModel insertInicisApproveDataOpPayInfo(ResponseApproveVo responseApproveVo, OrderInfoVo orderInfoVo, PayInfoVo payInfoVo) {
        return OpPayInfoModel.builder()
                .ordNo(orderInfoVo.getOrdNo())
                .payMnCd(OPT0009.VIRTUAL_ACCOUNT.getType())
                .payCcd(OPT0010.PAYMENT.getType())
                .payPrgsScd(OPT0011.PAYMENT_REQUEST.getType())
                .payAmt(Long.valueOf(responseApproveVo.getPrice()))
                .cnclAmt(0L)
                .rfndAvlAmt(0L)
                .trsnId(responseApproveVo.getTid())
                .vrValDt(responseApproveVo.getValidDate())
                .vrValTt(responseApproveVo.getValidTime())
                .vrAcct(responseApproveVo.getVacct())
                .vrAcctNm(responseApproveVo.getVacctName())
                .vrBnkCd(responseApproveVo.getVacctBankCode())
                .build();
    }

    public OpPayInfoModel insertPointApproveDataOpPayInfo(OrderInfoVo orderInfoVo, PayInfoVo payInfoVo) {
        return OpPayInfoModel.builder()
                .ordNo(orderInfoVo.getOrdNo())
                .payMnCd(OPT0009.POINT.getType())
                .payCcd(OPT0010.PAYMENT.getType())
                .payPrgsScd(OPT0011.PAYMENT_COMPLETE.getType())
                .payAmt(payInfoVo.getPayAmount())
                .cnclAmt(0L)
                .rfndAvlAmt(payInfoVo.getPayAmount())
                .build();
    }

    public OpPayInfoModel insertCancelDataOpPayInfo(RequestCancelVo requestCancelVo) {
        return OpPayInfoModel.builder()
                .ordNo(requestCancelVo.getOrdNo())
                .payMnCd(OPT0009.POINT.getType())
                .payCcd(OPT0010.CANCEL.getType())
                .payPrgsScd(OPT0011.REFUND_COMPLETE.getType())
                .payAmt(requestCancelVo.getCnclAmt())
                .cnclAmt(0L)
                .rfndAvlAmt(0L)
                .build();
    }
}
