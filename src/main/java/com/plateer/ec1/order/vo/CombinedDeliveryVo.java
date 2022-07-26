package com.plateer.ec1.order.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class CombinedDeliveryVo {
    private Long CombinedDeliveryNo;
    private List<ProductInfoVo> productInfoVoList;
}
