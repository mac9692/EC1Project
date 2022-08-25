package com.plateer.ec1.claim.creator;

import com.plateer.ec1.claim.mapper.ClaimTrxMapper;
import com.plateer.ec1.claim.vo.ClaimDataVo;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public abstract class AbstractClaimDataCreator implements ClaimDataCreator {

    private final ClaimTrxMapper claimTrxMapper;
    
    @Override
    public ClaimDataVo getInsertClaimData(RequestClaimVo requestClaimVo) {
        return null;
//        return ClaimDataVo
//                .builder()
//                .opClmInfoModel()
//                .opOrdCostInfoModel()
//                .opOrdBnfRelInfoModel()
//                .opOrdBnfInfoModel()
//                .opPayInfoModel()
//                .build();
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
