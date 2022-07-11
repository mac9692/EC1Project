package com.plateer.ec1.order.vo;

import com.plateer.ec1.order.enums.AfterStrategyType;
import com.plateer.ec1.order.enums.DataStrategyType;
import com.plateer.ec1.payment.vo.PayInfoVo;
import lombok.Data;

@Data
public class OrderRequest {
    private String orderNo;
    private DataStrategyType orderType;
    private AfterStrategyType systemType;
    private PayInfoVo payInfo;
}
