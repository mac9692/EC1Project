package com.plateer.ec1.order.vo;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderGoodsVo {
    private String ordGoodsNo;
    private String ordItemNo;
    private String goodsSellTpCd;

    @Min(value = 1, message = "주문 수량 개수는 0개 이상으로 입력하세요.")
    private Long orderCount;

    @Valid
    private List<ProductBenefitVo> productBenefitVoList;
}
