package com.plateer.ec1.order.vo;

import lombok.*;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductBenefitVo {
    private Long prmNo;
    private String cpnKndCd;
    private Long cpnIssNo;
    private Integer degrCcd;
}
