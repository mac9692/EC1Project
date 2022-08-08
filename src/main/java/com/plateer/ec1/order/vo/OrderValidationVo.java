package com.plateer.ec1.order.vo;

import com.plateer.ec1.order.vo.request.RequestOrderVo;

import java.util.List;

public class OrderValidationVo {

    private RequestOrderVo requestOrderVo;
    private List<OrderProductViewVo> productViews;

    public OrderValidationVo(RequestOrderVo requestOrderVo, List<OrderProductViewVo> productViews) {
        this.requestOrderVo = requestOrderVo;
        this.productViews = productViews;
    }
}
