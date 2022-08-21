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

    @NotNull(message = "환불은행코드는 Null 입력이 불가능합니다.")
    private String rfndBnkCk;

    @NotNull(message = "환불은행계좌번호는 Null 입력이 불가능합니다.")
    private String rfndAcctNo;

    @NotNull(message = "환불은행예금주는 Null 입력이 불가능합니다.")
    private String rfndAcctOwnNm;
}
