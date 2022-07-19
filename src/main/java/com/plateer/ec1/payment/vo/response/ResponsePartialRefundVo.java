package com.plateer.ec1.payment.vo.response;

import lombok.Data;

@Data
public class ResponsePartialRefundVo {
    private String resultMsg;
    private String resultCode;
    private String cancelDate;
    private String cancelTime;
    private String cshrCancelNum;
    private String detailResultCode;
    private String receiptInfo;
    private String tid;
    private String prtcTid;
    private String prtcPrice;
    private String prtcRemains;
    private String prtcCnt;
    private String prtcType;
    private String prtcDate;
    private String prtcTime;
    private String pointAmount;
    private String discountAmount;
    private String creditAmount;
}
