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
    private Long CombinedDeliveryNo;

    @Valid
    private List<ProductInfoVo> productInfoVoList;
}
