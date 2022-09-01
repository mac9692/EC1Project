package com.plateer.ec1.claim.processor.impl;

import com.plateer.ec1.claim.enums.ProcessorType;
import com.plateer.ec1.claim.helper.IFCallHelper;
import com.plateer.ec1.claim.helper.MonitoringLogHelper;
import com.plateer.ec1.claim.mapper.ClaimMapper;
import com.plateer.ec1.claim.processor.AbstractClaimProcessor;
import com.plateer.ec1.claim.processor.ClaimProcessor;
import com.plateer.ec1.claim.validator.ClaimValidator;
import com.plateer.ec1.claim.vo.ClaimDataVo;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import org.springframework.stereotype.Component;

@Component
public class GeneraCancelCompleteProcessor extends AbstractClaimProcessor implements ClaimProcessor {
    public GeneraCancelCompleteProcessor(ClaimValidator claimValidator, ClaimMapper claimMapper, MonitoringLogHelper monitoringLogHelper, IFCallHelper ifCallHelper) {
        super(claimValidator, claimMapper, monitoringLogHelper, ifCallHelper);
    }

    @Override
    public String getType() {
        return ProcessorType.GENERALORDERCANCEL.getType();
    }

    @Override
    public void claimProcess(RequestClaimVo requestClaimVo) {
        String claimNumber = getClaimNumber();
        long logSeq = insertMonitoringLog(requestClaimVo);
        if (isValidStatus(requestClaimVo)) {
            ClaimDataVo claimDataVo = getClaimData(requestClaimVo);
            insertClaimData(claimDataVo);
            updateClaimData(claimDataVo);
            if (isValidAmount(requestClaimVo)) {
                doPostProcess(claimDataVo);
                if (true) {
                    doPostProcess(claimDataVo);
                }
            }
        }
        updateMonitoringLog(logSeq, requestClaimVo);
    }

    @Override
    public void insertClaimData(ClaimDataVo claimDataVo) {

    }

    @Override
    public void updateClaimData(ClaimDataVo claimDataVo) {

    }
}
