package com.plateer.ec1.payment.vo.response;

import lombok.Data;

@Data
public class ResponseFullRefundVo {
    private String resultMsg;
    private String resultCode;
    private String cancelDate;
    private String cancelTime;
    private String cshrCancelNum;
    private String detailResultCode;
    private String receiptInfo;
}
