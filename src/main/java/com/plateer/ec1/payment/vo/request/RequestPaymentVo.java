package com.plateer.ec1.payment.vo.request;

import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class RequestPaymentVo {

    private OrderInfoVo orderInfoVo;
    private List<PayInfoVo> payInfoVoList;
}
