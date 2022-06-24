package com.plateer.ec1.claim.processor.impl;

import com.plateer.ec1.claim.creator.ClaimDataCreator;
import com.plateer.ec1.claim.enums.ProcessorType;
import com.plateer.ec1.claim.factory.ClaimDataCreatorFactory;
import com.plateer.ec1.claim.helper.IFCallHelper;
import com.plateer.ec1.claim.helper.MonitoringLogHelper;
import com.plateer.ec1.claim.processor.ClaimProcessor;
import com.plateer.ec1.claim.validator.ClaimValidator;
import com.plateer.ec1.claim.vo.Claim;
import com.plateer.ec1.common.model.order.ClaimModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CompleteProcessor implements ClaimProcessor {

    private final ClaimDataCreatorFactory claimDataCreatorFactory;
    private final ClaimValidator claimValidator;
    private final MonitoringLogHelper monitoringLogHelper;
    private final IFCallHelper ifCallHelper;

    @Override
    public ProcessorType getType() {
        return ProcessorType.COMPLETE;
    }

    @Override
    public void doProcess(Claim claim) {
        log.info("취소 완료 프로세스 시작");
        monitoringLogHelper.insertMonitoringLog(claim);
        claimValidator.isValidStatus(claim);
        ClaimDataCreator claimDataCreator = claimDataCreatorFactory.getClaimDataCreator(claim.getCreatorType());
        claimDataCreator.updateOrderClaim(new ClaimModel());
        claimDataCreator.getInsertClaimData(claim);
        claimValidator.isValidAmount(claim);
        ifCallHelper.callRestoreCoupon(claim);
        ifCallHelper.callPaymentIF(claim);
        monitoringLogHelper.updateMonitoringLog(1L, "abc");
    }
}
