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
    private Timestamp simpleDateFormat = Timestamp.valueOf(new SimpleDateFormat("yyyy.MM.dd hh:mm").format(now));
    public OpOrdBaseModel generalVirtualAccountUnPay(RequestOrderVo requestOrderVo) {
        return OpOrdBaseModel
                .builder()
                .ordTpCd(requestOrderVo.getOrderType())
                .ordSysCcd(requestOrderVo.getSystemType())
                .ordReqDtime(simpleDateFormat)
                .rfndBnkCk(requestOrderVo.getPayInfoVo().getRfndBnkCk())
                .rfndAcctNo(requestOrderVo.getPayInfoVo().getRfndAcctNo())
                .rfndAcctOwnNm(requestOrderVo.getPayInfoVo().getRfndAcctOwnNm())
                .build();
    }

    public OpOrdBaseModel generalVirtualAccountPayComplete(RequestOrderVo requestOrderVo) {
        return OpOrdBaseModel
                .builder()
                .ordTpCd(requestOrderVo.getOrderType())
                .ordSysCcd(requestOrderVo.getSystemType())
                .ordReqDtime(simpleDateFormat)
                .ordCmtDtime(simpleDateFormat)
                .rfndBnkCk(requestOrderVo.getPayInfoVo().getRfndBnkCk())
                .rfndAcctNo(requestOrderVo.getPayInfoVo().getRfndAcctNo())
                .rfndAcctOwnNm(requestOrderVo.getPayInfoVo().getRfndAcctOwnNm())
                .build();
    }
    public OpOrdBaseModel eCouponPointPay(RequestOrderVo requestOrderVo) {
        return OpOrdBaseModel
                .builder()
                .ordTpCd(requestOrderVo.getOrderType())
                .ordSysCcd(requestOrderVo.getSystemType())
                .ordReqDtime(simpleDateFormat)
                .ordCmtDtime(simpleDateFormat)
                .build();
    }
}
