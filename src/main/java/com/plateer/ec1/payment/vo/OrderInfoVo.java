package com.plateer.ec1.payment.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderInfoVo {

    @NotNull
    private String moid;

    @NotNull
    private String storeUrl;

    @NotNull
    private String ordNo;

    @NotNull
    private String goodName;

    @NotNull
    private String buyerName;

    @NotNull
    private String buyerEmail;
}
