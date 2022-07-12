package com.plateer.ec1.payment.vo.response;

import lombok.Data;

@Data
public class ResponseContextVo {
    private String resultMsg;
    private String resultCode;
    private String authDate;
    private String authTime;
    private String vacct;
    private String vacctBankCode;
    private String validDate;
    private String validTime;
    private String inputName;
    private String tid;
    private String price;
    private String vacctName;
    private String refundAcct;
    private String refundBankCode;
    private String refundAcctName;
}
