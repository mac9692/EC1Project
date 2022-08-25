package com.plateer.ec1.claim.vo;

import com.plateer.ec1.common.model.order.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClaimDataVo {
    private List<OpClmInfoModel> opClmInfoModelList;
    private List<OpOrdCostInfoModel> opOrdCostInfoModelList;
    private List<OpOrdBnfRelInfoModel> opOrdBnfRelInfoModelList;
    private List<OpOrdBnfInfoModel> opOrdBnfInfoModelList;
    private List<OpPayInfoModel> opPayInfoModelList;
}
