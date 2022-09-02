package com.plateer.ec1.claim.vo;

import com.plateer.ec1.common.model.order.*;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ClaimDataVo {
    private Long logSeq;
    private String orderNo;
    private String claimNo;
    private List<OpClmInfoModel> opClmInfoModelList;
    private List<OpOrdCostInfoModel> opOrdCostInfoModelList;
    private List<OpOrdBnfRelInfoModel> opOrdBnfRelInfoModelList;
    private List<OpOrdBnfInfoModel> opOrdBnfInfoModelList;
}
