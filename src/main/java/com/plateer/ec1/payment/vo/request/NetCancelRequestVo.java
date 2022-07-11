package com.plateer.ec1.payment.vo.request;

import com.plateer.ec1.payment.enums.PaymentType;
import lombok.Data;

@Data
public class NetCancelRequestVo {

    private PaymentType paymentType;

}
