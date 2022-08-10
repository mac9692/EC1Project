package com.plateer.ec1.common.model.order;

import com.plateer.ec1.order.vo.request.RequestOrderVo;
import lombok.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpOrdBaseModel {

    private String ordNo;
    private String mbrNo;
    private String ordTpCd;
    private String ordSysCcd;
    private Timestamp ordReqDtime;
    private Timestamp ordCmtDtime;
    private String ordNm;
    private String ordSellNo;
    private String ordAddr;
    private String ordAddrDtl;
    private String rfndBnkCk;
    private String rfndAcctNo;
    private String rfndAcctOwnNm;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModrId;
    private String sysModDtim;
    private Timestamp now = new Timestamp(System.currentTimeMillis());

    public OpOrdBaseModel generalVirtualAccountUnPay(RequestOrderVo requestOrderVo) {
        return OpOrdBaseModel
                .builder()
                .ordNo(requestOrderVo.getOrderNo())
                .mbrNo(requestOrderVo.getOrderVo().getMbrNo())
                .ordNm(requestOrderVo.getOrderVo().getOrdNm())
                .ordSellNo(requestOrderVo.getOrderVo().getOrdSellNo())
                .ordAddr(requestOrderVo.getOrderVo().getOrdAddr())
                .ordAddrDtl(requestOrderVo.getOrderVo().getOrdAddrDtl())
                .ordTpCd(requestOrderVo.getOrderType())
                .ordSysCcd(requestOrderVo.getSystemType())
                .ordReqDtime(now)
                .rfndBnkCk(requestOrderVo.getPayInfoVoList().get(0).getRfndBnkCk())
                .rfndAcctNo(requestOrderVo.getPayInfoVoList().get(0).getRfndAcctNo())
                .rfndAcctOwnNm(requestOrderVo.getPayInfoVoList().get(0).getRfndAcctOwnNm())
                .build();
    }

    public OpOrdBaseModel generalVirtualAccountPayComplete(RequestOrderVo requestOrderVo) {
        return OpOrdBaseModel
                .builder()
                .ordNo(requestOrderVo.getOrderNo())
                .mbrNo(requestOrderVo.getOrderVo().getMbrNo())
                .ordNm(requestOrderVo.getOrderVo().getOrdNm())
                .ordSellNo(requestOrderVo.getOrderVo().getOrdSellNo())
                .ordAddr(requestOrderVo.getOrderVo().getOrdAddr())
                .ordAddrDtl(requestOrderVo.getOrderVo().getOrdAddrDtl())
                .ordTpCd(requestOrderVo.getOrderType())
                .ordSysCcd(requestOrderVo.getSystemType())
                .ordReqDtime(now)
                .ordCmtDtime(now)
                .rfndBnkCk(requestOrderVo.getPayInfoVoList().get(0).getRfndBnkCk())
                .rfndAcctNo(requestOrderVo.getPayInfoVoList().get(0).getRfndAcctNo())
                .rfndAcctOwnNm(requestOrderVo.getPayInfoVoList().get(0).getRfndAcctOwnNm())
                .build();
    }
    public OpOrdBaseModel eCouponPointPay(RequestOrderVo requestOrderVo) {
        return OpOrdBaseModel
                .builder()
                .ordNo(requestOrderVo.getOrderNo())
                .mbrNo(requestOrderVo.getOrderVo().getMbrNo())
                .ordNm(requestOrderVo.getOrderVo().getOrdNm())
                .ordSellNo(requestOrderVo.getOrderVo().getOrdSellNo())
                .ordAddr(requestOrderVo.getOrderVo().getOrdAddr())
                .ordAddrDtl(requestOrderVo.getOrderVo().getOrdAddrDtl())
                .ordTpCd(requestOrderVo.getOrderType())
                .ordSysCcd(requestOrderVo.getSystemType())
                .ordReqDtime(now)
                .ordCmtDtime(now)
                .build();
    }
}
