package com.plateer.ec1.claim.creator.impl;

import com.plateer.ec1.claim.creator.AbstractClaimDataCreator;
import com.plateer.ec1.claim.creator.ClaimDataCreator;
import com.plateer.ec1.claim.enums.CreatorType;
import com.plateer.ec1.claim.mapper.ClaimMapper;
import com.plateer.ec1.claim.mapper.ClaimTrxMapper;
import com.plateer.ec1.claim.vo.ClaimDataVo;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class GeneralOrderCancelDataCreator extends AbstractClaimDataCreator implements ClaimDataCreator {

    public GeneralOrderCancelDataCreator(ClaimMapper claimMapper) {
        super(claimMapper);
    }

    @Override
    public String getType() {
        return CreatorType.GENERALORDERCANCEL.getType();
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
