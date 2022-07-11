package com.plateer.ec1.payment.vo.request;

import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import lombok.Data;

import java.util.List;

@Data
public class PaymentRequestVo {

    private OrderInfoVo orderInfoVo;
    private List<PayInfoVo> payInfoVoList;
}
