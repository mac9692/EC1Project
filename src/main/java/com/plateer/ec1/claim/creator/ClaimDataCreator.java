package com.plateer.ec1.claim.creator;

import com.plateer.ec1.claim.enums.CreatorType;
import com.plateer.ec1.claim.vo.Claim;
import com.plateer.ec1.common.model.order.ClaimModel;

public interface ClaimDataCreator {

    CreatorType getType();

    ClaimModel getInsertClaimData(Claim claim);

    ClaimModel getUpdateClaimData(Claim claim);

    void updateOrderBenefitData(Claim claim);

    ClaimModel insertOrderBenefitRelation(ClaimModel claimModel);

    void updateOrderCost(ClaimModel claimModel);

    ClaimModel insertOrderCost(ClaimModel claimModel);

    void updateOrderClaim(ClaimModel claimModel);

    ClaimModel insertOrderClaim(ClaimModel claimModel);
}
