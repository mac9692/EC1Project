package com.plateer.ec1.claim.processor.impl;

import com.plateer.ec1.claim.creator.ClaimDataCreator;
import com.plateer.ec1.claim.enums.ProcessorType;
import com.plateer.ec1.claim.factory.ClaimDataCreatorFactory;
import com.plateer.ec1.claim.helper.IFCallHelper;
import com.plateer.ec1.claim.helper.MonitoringLogHelper;
import com.plateer.ec1.claim.processor.ClaimProcessor;
import com.plateer.ec1.claim.validator.ClaimValidator;
import com.plateer.ec1.claim.vo.ClaimDataVo;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
@RequiredArgsConstructor
public class CompleteProcessor implements ClaimProcessor {

    private final ClaimDataCreatorFactory claimDataCreatorFactory;
    private final ClaimValidator claimValidator;
    private final MonitoringLogHelper monitoringLogHelper;
    private final IFCallHelper ifCallHelper;

    @Override
    public String getType() {
        return ProcessorType.COMPLETE.getType();
    }

    @Transactional
    @Override
    public void doProcess(RequestClaimVo requestClaimVo) {
        Long logSeq = monitoringLogHelper.insertMonitoringLog(requestClaimVo);
        log.info(String.valueOf(logSeq));
        claimValidator.isValidStatus(requestClaimVo);
        ClaimDataCreator claimDataCreator = claimDataCreatorFactory.getClaimDataCreator(requestClaimVo.getCreatorType());
        ClaimDataVo claimDataVo = claimDataCreator.doProcess(requestClaimVo);
        claimValidator.isValidAmount(requestClaimVo);
        ifCallHelper.callRestoreCoupon(requestClaimVo);
        ifCallHelper.callPaymentIF(requestClaimVo);
        monitoringLogHelper.updateMonitoringLog(logSeq, claimDataVo);
    }
}
