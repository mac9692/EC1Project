package com.plateer.ec1.claim.creator.impl;

import com.plateer.ec1.claim.creator.ClaimDataCreator;
import com.plateer.ec1.claim.enums.CreatorType;
import com.plateer.ec1.claim.vo.ClaimDataVo;

public class GeneralOrderCancelDataCreator implements ClaimDataCreator {
    @Override
    public String getType() {
        return CreatorType.GENERALORDERCANCEL.getType();
    }

    @Override
    public void getInsertClaimData(ClaimDataVo claimDataVo) {

    }

    @Override
    public void getUpdateClaimData(ClaimDataVo claimDataVo) {

    }

    @Override
    public void updateOrderBenefitData(ClaimDataVo claimDataVo) {

    }

    @Override
    public void insertOrderBenefitRelation(ClaimDataVo claimDataVo) {

    }

    @Override
    public void updateOrderCost(ClaimDataVo claimDataVo) {

    }

    @Override
    public void insertOrderCost(ClaimDataVo claimDataVo) {

    }

    @Override
    public void updateOrderClaimData(ClaimDataVo claimDataVo) {

    }

    @Override
    public void insertOrderClaimData(ClaimDataVo claimDataVo) {

    }

}
