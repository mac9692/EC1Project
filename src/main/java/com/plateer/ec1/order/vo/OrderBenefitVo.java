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
    private String ordBnfNo;
    private Long prmNo;
    private String cpnKndCd;
    private Long cpnIssNo;
    private Integer degrCcd;
    private Integer ordCnclBnfAmt;

    @Valid
    private List<OrderBenefitProductVo> orderBenefitProductVoList;
}
