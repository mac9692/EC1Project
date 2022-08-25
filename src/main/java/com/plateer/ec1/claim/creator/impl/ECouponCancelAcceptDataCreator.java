package com.plateer.ec1.claim.creator.impl;

import com.plateer.ec1.claim.creator.AbstractClaimDataCreator;
import com.plateer.ec1.claim.creator.ClaimDataCreator;
import com.plateer.ec1.claim.enums.CreatorType;
import com.plateer.ec1.claim.mapper.ClaimMapper;
import com.plateer.ec1.claim.mapper.ClaimTrxMapper;
import com.plateer.ec1.claim.vo.ClaimDataVo;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ECouponCancelAcceptDataCreator extends AbstractClaimDataCreator implements ClaimDataCreator {

    public ECouponCancelAcceptDataCreator(ClaimMapper claimMapper) {
        super(claimMapper);
    }

    @Override
    public String getType() {
        return CreatorType.ECOUPONCANCELACCEPT.getType();
    }

    @Override
    public String doProcess(RequestClaimVo requestClaimVo) {
        return null;
    }

    @Override
    public ClaimDataVo insertClaimData(RequestClaimVo requestClaimVo) {
        ClaimDataVo claimDataVo = super.getInsertClaimData(requestClaimVo);
        return claimDataVo;
    }

    @Override
    public ClaimDataVo updateClaimData(RequestClaimVo requestClaimVo) {
        ClaimDataVo claimDataVo = super.getUpdateClaimData(requestClaimVo);
        return claimDataVo;
    }


}
