package com.plateer.ec1.payment.vo;

import com.plateer.ec1.payment.enums.PaymentType;
import lombok.Data;

@Data
public class PayInfoVo {

    private long payAmount;
    private String bankCode;
    private PaymentType paymentType;
    private String depositorName;
}
