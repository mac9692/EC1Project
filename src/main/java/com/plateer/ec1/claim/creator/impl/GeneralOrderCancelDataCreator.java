package com.plateer.ec1.claim.creator.impl;

import com.plateer.ec1.claim.creator.ClaimDataCreator;
import com.plateer.ec1.claim.enums.CreatorType;
import com.plateer.ec1.claim.vo.Claim;

public class GeneralOrderCancelDataCreator implements ClaimDataCreator {
    @Override
    public CreatorType getType() {
        return CreatorType.GENERALORDERCANCEL;
    }
//
//    @Override
//    public ClaimModel getInsertClaimData(Claim claim) {
//        return null;
//    }
//
//    @Override
//    public ClaimModel getUpdateClaimData(Claim claim) {
//        return null;
//    }
//
//    @Override
//    public void updateOrderBenefitData(Claim claim) {
//
//    }
//
//    @Override
//    public ClaimModel insertOrderBenefitRelation(ClaimModel claimModel) {
//        return null;
//    }
//
//    @Override
//    public void updateOrderCost(ClaimModel claimModel) {
//
//    }
//
//    @Override
//    public ClaimModel insertOrderCost(ClaimModel claimModel) {
//        return null;
//    }
//
//    @Override
//    public void updateOrderClaim(ClaimModel claimModel) {
//
//    }
//
//    @Override
//    public ClaimModel insertOrderClaim(ClaimModel claimModel) {
//        return null;
//    }
}
