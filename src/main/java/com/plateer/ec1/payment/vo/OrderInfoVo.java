package com.plateer.ec1.payment.vo;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class OrderInfoVo {
    private String moid;

    private String storeUrl;

    @NotNull
    private String ordNo;

    @NotNull
    private String goodName;

    @NotNull
    private String buyerName;

    private String buyerEmail;
}
