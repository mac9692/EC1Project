package com.plateer.ec1.claim.creator;

import com.plateer.ec1.claim.vo.ClaimDataVo;

public interface ClaimDataCreator {

    String getType();
//
    void getInsertClaimData(ClaimDataVo claimDataVo);

    void getUpdateClaimData(ClaimDataVo claimDataVo);

    void updateOrderBenefitData(ClaimDataVo claimDataVo);

    void insertOrderBenefitRelation(ClaimDataVo claimDataVo);

    void updateOrderCost(ClaimDataVo claimDataVo);

    void insertOrderCost(ClaimDataVo claimDataVo);

    void updateOrderClaimData(ClaimDataVo claimDataVo);

    void insertOrderClaimData(ClaimDataVo claimDataVo);
}
