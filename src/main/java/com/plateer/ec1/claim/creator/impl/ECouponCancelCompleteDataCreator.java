package com.plateer.ec1.claim.creator.impl;

import com.plateer.ec1.claim.creator.AbstractClaimDataCreator;
import com.plateer.ec1.claim.creator.ClaimDataCreator;
import com.plateer.ec1.claim.enums.CreatorType;
import com.plateer.ec1.claim.mapper.ClaimTrxMapper;
import com.plateer.ec1.claim.vo.ClaimDataVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ECouponCancelCompleteDataCreator extends AbstractClaimDataCreator implements ClaimDataCreator {
    public ECouponCancelCompleteDataCreator(ClaimTrxMapper claimTrxMapper) {
        super(claimTrxMapper);
    }

    @Override
    public String getType() {
        return CreatorType.ECOUPONCANCELCOMPLETE.getType();
    }

    @Override
    public void insertClaimData(ClaimDataVo claimDataVo) {
    }

    @Override
    public void updateClaimData(ClaimDataVo claimDataVo) {

    }

}
