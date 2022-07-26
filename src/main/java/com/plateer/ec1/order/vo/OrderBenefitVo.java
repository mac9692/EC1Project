package com.plateer.ec1.order.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
public class OrderBenefitVo {
    private Long prmNo;
    private String cpnKndCd;
    private Long cpnIssNo;
    private Integer degrCcd;
    private List<OrderBenefitProductVo> orderBenefitProductVoList;
}
