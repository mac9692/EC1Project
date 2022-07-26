package com.plateer.ec1.payment.vo;

import com.plateer.ec1.payment.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
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
