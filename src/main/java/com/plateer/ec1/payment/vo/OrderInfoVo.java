package com.plateer.ec1.payment.vo;

import lombok.Data;

@Data
public class OrderInfoVo {

    private String moid;
    private String storeUrl;
    private String ordNo;
    private String goodName;
    private String buyerName;
    private String buyerEmail;
}
