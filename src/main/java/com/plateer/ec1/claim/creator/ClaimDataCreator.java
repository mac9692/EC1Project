package com.plateer.ec1.claim.creator;

import com.plateer.ec1.claim.vo.ClaimDataVo;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;

public interface ClaimDataCreator {

    String getType();

    String doProcess(RequestClaimVo requestClaimVo);

    ClaimDataVo getInsertClaimData(RequestClaimVo requestClaimVo);

    ClaimDataVo getUpdateClaimData(RequestClaimVo requestClaimVo);

    ClaimDataVo insertClaimData(RequestClaimVo requestClaimVo);

    ClaimDataVo updateClaimData(RequestClaimVo requestClaimVo);
}
