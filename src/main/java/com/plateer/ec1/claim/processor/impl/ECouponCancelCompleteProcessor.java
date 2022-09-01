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
public class ECouponCancelCompleteProcessor extends AbstractClaimProcessor implements ClaimProcessor {
    public ECouponCancelCompleteProcessor(ClaimValidator claimValidator, ClaimMapper claimMapper, MonitoringLogHelper monitoringLogHelper, IFCallHelper ifCallHelper) {
        super(claimValidator, claimMapper, monitoringLogHelper, ifCallHelper);
    }

    @Override
    public String getType() {
        return ProcessorType.ECOUPONCANCELCOMPLETE.getType();
    }

    @Override
    public void claimProcess(RequestClaimVo requestClaimVo) {
    }

    @Override
    public void insertClaimData(ClaimDataVo claimDataVo) {

    }

    @Override
    public void updateClaimData(ClaimDataVo claimDataVo) {

    }
}
