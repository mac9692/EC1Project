package com.plateer.ec1.order.vo;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderBenefitProductVo {
    private Integer ordSeq;
    private Integer procSeq;
    private String ordGoodsNo;
    private String ordItemNo;
    private Long aplyAmt;
}
