package com.plateer.ec1.payment.vo.request;


import com.plateer.ec1.payment.enums.PaymentType;
import com.plateer.ec1.payment.enums.RefundType;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RequestCancelVo {

    @NotEmpty
    private String paymentType;

    @NotEmpty
    private String ordNo;

    @NotEmpty
    private Long clmNo;

    @NotEmpty
    private Long cnclAmt;

}
