package com.plateer.ec1.claim.creator;

import com.plateer.ec1.claim.vo.ClaimDataVo;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;

public interface ClaimDataCreator {

    String getType();

    ClaimDataVo getInsertClaimData(RequestClaimVo requestClaimVo);

    ClaimDataVo getUpdateClaimData(RequestClaimVo requestClaimVo);

    void insertClaimData(ClaimDataVo claimDataVo);

    void updateClaimData(ClaimDataVo claimDataVo);

    ClaimDataVo doProcess(RequestClaimVo requestClaimVo);
}
