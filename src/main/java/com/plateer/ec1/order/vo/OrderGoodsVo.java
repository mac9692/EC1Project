package com.plateer.ec1.order.vo;

import lombok.*;

import java.util.List;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderGoodsVo {
    private String ordGoodsNo;
    private String ordItemNo;
    private String goodsSellTpCd;
    private Long orderCount;
    private List<ProductBenefitVo> productBenefitVoList;
}
