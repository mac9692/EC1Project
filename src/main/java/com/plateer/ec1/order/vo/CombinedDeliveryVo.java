package com.plateer.ec1.order.vo;

import lombok.*;

import javax.validation.Valid;
import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CombinedDeliveryVo {
    private String orderCostNo;
    private Integer combinedDeliveryNo;

    @Valid
    private List<ProductInfoVo> productInfoVoList;
}
