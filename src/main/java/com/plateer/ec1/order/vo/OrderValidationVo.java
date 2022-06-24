package com.plateer.ec1.order.vo;

import java.util.List;

public class OrderValidationVo {

    private OrderRequest orderRequest;
    private List<OrderProductView> productViews;

    public OrderValidationVo(OrderRequest orderRequest, List<OrderProductView> productViews) {
        this.orderRequest = orderRequest;
        this.productViews = productViews;
    }
}
