package com.plateer.ec1.claim.creator.impl;

import com.plateer.ec1.claim.creator.AbstractClaimDataCreator;
import com.plateer.ec1.claim.creator.ClaimDataCreator;
import com.plateer.ec1.claim.enums.CreatorType;
import com.plateer.ec1.claim.mapper.ClaimMapper;
import com.plateer.ec1.claim.mapper.ClaimTrxMapper;
import com.plateer.ec1.claim.vo.ClaimDataVo;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ECouponCancelCompleteDataCreator extends AbstractClaimDataCreator implements ClaimDataCreator {
    private final ClaimTrxMapper claimTrxMapper;

    public ECouponCancelCompleteDataCreator(ClaimMapper claimMapper, ClaimTrxMapper claimTrxMapper) {
        super(claimMapper);
        this.claimTrxMapper = claimTrxMapper;
    }

    @Override
    public String getType() {
        return CreatorType.ECOUPONCANCELCOMPLETE.getType();
    }

    @Override
    public ClaimDataVo doProcess(RequestClaimVo requestClaimVo) {
        ClaimDataVo insertClaimData = super.getInsertClaimData(requestClaimVo);
        ClaimDataVo updateClaimData = super.getUpdateClaimData(requestClaimVo);
        return insertClaimData;
    }

    @Override
    public ClaimDataVo insertClaimData(ClaimDataVo claimDataVo) {
        return null;

    }

    @Override
    public ClaimDataVo updateClaimData(ClaimDataVo claimDataVo) {
        return null;
    }

}
