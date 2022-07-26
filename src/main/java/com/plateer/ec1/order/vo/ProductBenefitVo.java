package com.plateer.ec1.order.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class ProductBenefitVo {
    private Long prmNo;
    private String cpnKndCd;
    private Long cpnIssNo;
    private Integer degrCcd;
}
