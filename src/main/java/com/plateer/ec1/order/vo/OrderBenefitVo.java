package com.plateer.ec1.order.vo;

import lombok.*;

import java.util.List;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderBenefitVo {
    private Long prmNo;
    private String cpnKndCd;
    private Long cpnIssNo;
    private Integer degrCcd;
    private List<OrderBenefitProductVo> orderBenefitProductVoList;
}
