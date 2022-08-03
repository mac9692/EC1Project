package com.plateer.ec1.payment.vo;

import com.plateer.ec1.payment.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
