package com.plateer.ec1.claim.creator;

import com.plateer.ec1.claim.mapper.ClaimMapper;
import com.plateer.ec1.claim.mapper.ClaimTrxMapper;
import com.plateer.ec1.claim.vo.ClaimDataVo;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import com.plateer.ec1.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public abstract class AbstractClaimDataCreator implements ClaimDataCreator {

    private final ClaimMapper claimMapper;

    @Override
    public ClaimDataVo getInsertClaimData(RequestClaimVo requestClaimVo) {
        return ClaimDataVo
                .builder()
                .opClmInfoModelList(claimMapper.getOpClmInfoModelList(requestClaimVo))
                .opOrdCostInfoModelList(claimMapper.getOpOrdCostInfoModelList(requestClaimVo))
                .opOrdBnfRelInfoModelList(claimMapper.getOpOrdBnfRelInfoModelList(requestClaimVo))
                .opOrdBnfInfoModelList(claimMapper.getOpOrdBnfInfoModelList(requestClaimVo))
//                .opPayInfoModelList(claimMapper.getOpPayInfoModelList(requestClaimVo))
                .build();
    }

    @Override
    public ClaimDataVo getUpdateClaimData(RequestClaimVo requestClaimVo) {
        return null;
    }
}
