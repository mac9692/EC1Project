package com.plateer.ec1.claim.creator.impl;

import com.plateer.ec1.claim.creator.AbstractClaimDataCreator;
import com.plateer.ec1.claim.creator.ClaimDataCreator;
import com.plateer.ec1.claim.enums.CreatorType;
import com.plateer.ec1.claim.mapper.ClaimTrxMapper;
import com.plateer.ec1.claim.vo.ClaimDataVo;
import org.springframework.stereotype.Component;

@Component
public class GeneralOrderCancelDataCreator extends AbstractClaimDataCreator implements ClaimDataCreator {
    public GeneralOrderCancelDataCreator(ClaimTrxMapper claimTrxMapper) {
        super(claimTrxMapper);
    }

    @Override
    public String getType() {
        return CreatorType.GENERALORDERCANCEL.getType();
    }

    @Override
    public void insertClaimData(ClaimDataVo claimDataVo) {
    }

    @Override
    public void updateClaimData(ClaimDataVo claimDataVo) {

    }

}
