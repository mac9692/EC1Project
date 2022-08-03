package com.plateer.ec1.order.vo;

import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CombinedDeliveryVo {
    private Long CombinedDeliveryNo;
    private List<ProductInfoVo> productInfoVoList;
}
