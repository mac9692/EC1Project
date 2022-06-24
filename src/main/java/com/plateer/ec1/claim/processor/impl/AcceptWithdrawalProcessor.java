package com.plateer.ec1.claim.processor.impl;

import com.plateer.ec1.claim.creator.ClaimDataCreator;
import com.plateer.ec1.claim.enums.ProcessorType;
import com.plateer.ec1.claim.factory.ClaimDataCreatorFactory;
import com.plateer.ec1.claim.helper.MonitoringLogHelper;
import com.plateer.ec1.claim.processor.ClaimProcessor;
import com.plateer.ec1.claim.validator.ClaimValidator;
import com.plateer.ec1.claim.vo.Claim;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
@RequiredArgsConstructor
public class AcceptWithdrawalProcessor implements ClaimProcessor {

    private final ClaimDataCreatorFactory claimDataCreatorFactory;
    private final ClaimValidator claimValidator;
    private final MonitoringLogHelper monitoringLogHelper;

    @Override
    public ProcessorType getType() {
        return ProcessorType.ACCEPT_WITHDRAWAL;
    }

    @Override
    @Transactional
    public void doProcess(Claim claim) {
        log.info("접수 OR 철회 프로세스 시작");
        log.info("클레임 번호 채번");
        monitoringLogHelper.insertMonitoringLog(claim);
        claimValidator.isValidStatus(claim);
        ClaimDataCreator claimDataCreator = claimDataCreatorFactory.getClaimDataCreator(claim.getCreatorType());
        claimDataCreator.getInsertClaimData(claim);
    }
}
