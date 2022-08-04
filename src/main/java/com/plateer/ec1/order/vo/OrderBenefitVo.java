package com.plateer.ec1.order.vo;

import lombok.*;

import javax.validation.Valid;
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

    @Valid
    private List<OrderBenefitProductVo> orderBenefitProductVoList;
}
