package com.plateer.ec1.common.model.order;

import com.plateer.ec1.order.vo.request.RequestOrderVo;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Getter
@Setter
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
        setOrdTpCd(requestOrderVo.getOrderType().getType());
        setOrdSysCcd(requestOrderVo.getSystemType().getType());
        setOrdReqDtime(simpleDateFormat);
        setRfndBnkCk(requestOrderVo.getPayInfoVo().getRfndBnkCk());
        setRfndAcctNo(requestOrderVo.getPayInfoVo().getRfndAcctNo());
        setRfndAcctOwnNm(requestOrderVo.getPayInfoVo().getRfndAcctOwnNm());
        return this;
    }

    public OpOrdBaseModel generalVirtualAccountPayComplete(RequestOrderVo requestOrderVo) {
        setOrdCmtDtime(simpleDateFormat);
        return this;
    }
    public OpOrdBaseModel eCouponPointPay(RequestOrderVo requestOrderVo) {
        setOrdTpCd(requestOrderVo.getOrderType().getType());
        setOrdSysCcd(requestOrderVo.getSystemType().getType());
        setOrdReqDtime(simpleDateFormat);
        setOrdCmtDtime(simpleDateFormat);
        return this;
    }
}
