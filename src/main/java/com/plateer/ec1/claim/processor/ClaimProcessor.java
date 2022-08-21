package com.plateer.ec1.claim.processor;

import com.plateer.ec1.claim.vo.request.RequestClaimVo;

public interface ClaimProcessor {

    String getType();

    void doProcess(RequestClaimVo requestClaimVo);
}
