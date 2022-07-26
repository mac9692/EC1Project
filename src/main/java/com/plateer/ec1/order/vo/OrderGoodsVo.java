package com.plateer.ec1.order.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
public class OrderGoodsVo {
    private String ordGoodsNo;
    private String ordItemNo;
    private String goodsSellTpCd;
    private Long orderCount;
    private List<ProductBenefitVo> productBenefitVoList;
}
