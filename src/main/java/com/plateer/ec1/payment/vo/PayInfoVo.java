package com.plateer.ec1.payment.vo;

import com.plateer.ec1.payment.enums.PaymentType;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PayInfoVo {

    @NotNull
    private Long payAmount;

    @NotNull
    private String bankCode;

    @NotNull
    private PaymentType paymentType;

    @NotNull
    private String depositorName;
}
