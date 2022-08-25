package com.plateer.ec1.claim.creator.impl;

import com.plateer.ec1.claim.creator.AbstractClaimDataCreator;
import com.plateer.ec1.claim.creator.ClaimDataCreator;
import com.plateer.ec1.claim.enums.CreatorType;
import com.plateer.ec1.claim.vo.ClaimDataVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ECouponCancelAcceptDataCreator extends AbstractClaimDataCreator implements ClaimDataCreator {
    @Override
    public String getType() {
        return CreatorType.ECOUPONCANCELACCEPT.getType();
    }

    @Override
    public void insertClaimData(ClaimDataVo claimDataVo) {
    }

    @Override
    public void updateClaimData(ClaimDataVo claimDataVo) {

    }


}
