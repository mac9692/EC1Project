package com.plateer.ec1.claim.vo;

import com.plateer.ec1.common.model.order.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClaimDataVo {
    private OpClmInfoModel opClmInfoModel;
    private OpOrdCostInfoModel opOrdCostInfoModel;
    private OpOrdBnfRelInfoModel opOrdBnfRelInfoModel;
    private OpOrdBnfInfoModel opOrdBnfInfoModel;
    private OpPayInfoModel opPayInfoModel;
}
