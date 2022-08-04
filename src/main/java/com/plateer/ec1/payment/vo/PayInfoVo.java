package com.plateer.ec1.payment.vo;

import com.plateer.ec1.payment.enums.PaymentType;
import lombok.*;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PayInfoVo {

    @NotNull
    private Long payAmount;

    @NotNull
    private String bankCode;

    @NotNull
    private PaymentType paymentType;

    @NotNull
    private String depositorName;

    @NotNull
    private String rfndBnkCk;

    @NotNull
    private String rfndAcctNo;

    @NotNull
    private String rfndAcctOwnNm;
}
