package com.plateer.ec1.claim.processor;

import com.plateer.ec1.claim.vo.ClaimDataVo;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;

public interface ClaimProcessor {

    String getType();

    void doProcess(RequestClaimVo requestClaimVo);

    void claimProcess(RequestClaimVo requestClaimVo);

    String getClaimNumber();

    Long insertMonitoringLog(RequestClaimVo requestClaimVo);

    ClaimDataVo getClaimData(RequestClaimVo requestClaimVo);

    ClaimDataVo insertClaimData(ClaimDataVo claimDataVo);

    ClaimDataVo updateClaimData(ClaimDataVo claimDataVo);

    boolean isValidAmount(RequestClaimVo requestClaimVo);

    void interfaceCall(RequestClaimVo requestClaimVo);

    void doPostProcess(ClaimDataVo claimDataVo);

    void updateMonitoringLog(Long logSeq, ClaimDataVo insertData, ClaimDataVo updateData);
}
