package com.plateer.ec1.claim.creator;

import com.plateer.ec1.claim.vo.ClaimDataVo;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractClaimDataCreator implements ClaimDataCreator {

    @Override
    public ClaimDataVo getInsertClaimData(RequestClaimVo requestClaimVo) {
        return ClaimDataVo
                .builder()
                .opClmInfoModel()
                .opOrdCostInfoModel()
                .opOrdBnfRelInfoModel()
                .opOrdBnfInfoModel()
                .opPayInfoModel()
                .build();
    }

    @Override
    public ClaimDataVo getUpdateClaimData(RequestClaimVo requestClaimVo) {
        return null;
    }

    @Transactional
    @Override
    public ClaimDataVo doProcess(RequestClaimVo requestClaimVo) {
        ClaimDataVo insertData = getInsertClaimData(requestClaimVo);
        ClaimDataVo updateData = getUpdateClaimData(requestClaimVo);
        insertClaimData(insertData);
        updateClaimData(updateData);

        return insertData;
    }
}
