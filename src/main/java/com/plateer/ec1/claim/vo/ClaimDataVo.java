package com.plateer.ec1.claim.vo;

import com.plateer.ec1.claim.vo.request.RequestClaimVo;
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
//
//    public ClaimDataVo getInsertClaimData(RequestClaimVo requestClaimVo) {
//        return ClaimDataVo
//                .builder()
//                .opClmInfoModel()
//                .opOrdCostInfoModel()
//                .opOrdBnfRelInfoModel()
//                .opOrdBnfInfoModel()
//                .opPayInfoModel()
//                .build();
//    }

//    public ClaimDataVo getUpdateClaimData(RequestClaimVo requestClaimVo) {
//        return ClaimDataVo
//                .builder()
//                .opClmInfoModel()
//                .opOrdCostInfoModel()
//                .opOrdBnfRelInfoModel()
//                .opOrdBnfInfoModel()
//                .opPayInfoModel()
//                .build();
//    }
}
