package com.plateer.ec1.claim.creator.impl;

import com.plateer.ec1.claim.creator.ClaimDataCreator;
import com.plateer.ec1.claim.enums.CreatorType;
import com.plateer.ec1.claim.vo.Claim;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ECouponCancelAcceptDataCreator implements ClaimDataCreator {
    @Override
    public CreatorType getType() {
        return CreatorType.ECOUPONCANCELACCEPT;
    }
//
//    @Override
//    public void getInsertClaimData(Claim claim) {
//        return null;
//    }
//
//    @Override
//    public void getUpdateClaimData(Claim claim) {
//        return null;
//    }
//
//    @Override
//    public void updateOrderBenefitData(Claim claim) {
//
//    }
//
//    @Override
//    public void insertOrderBenefitRelation(ClaimModel claimModel) {
//        return null;
//    }
//
//    @Override
//    public void updateOrderCost(ClaimModel claimModel) {
//
//    }
//
//    @Override
//    public void insertOrderCost(ClaimModel claimModel) {
//        return null;
//    }
//
//    @Override
//    public void updateOrderClaim(ClaimModel claimModel) {
//
//    }
//
//    @Override
//    public void insertOrderClaim(ClaimModel claimModel) {
//        return null;
//    }

}
