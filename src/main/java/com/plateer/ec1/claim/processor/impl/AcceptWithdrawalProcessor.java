package com.plateer.ec1.claim.processor.impl;

import com.plateer.ec1.claim.creator.ClaimDataCreator;
import com.plateer.ec1.claim.enums.ProcessorType;
import com.plateer.ec1.claim.factory.ClaimDataCreatorFactory;
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
public class AcceptWithdrawalProcessor implements ClaimProcessor {

    private final ClaimDataCreatorFactory claimDataCreatorFactory;
    private final ClaimValidator claimValidator;
    private final MonitoringLogHelper monitoringLogHelper;

    @Override
    public String getType() {
        return ProcessorType.ACCEPT_WITHDRAWAL.getType();
    }

    @Override
    @Transactional
    public void doProcess(RequestClaimVo requestClaimVo) {
        log.info("접수 OR 철회 프로세스 시작");
        log.info("클레임 번호 채번");
        Long logSeq = monitoringLogHelper.insertMonitoringLog(requestClaimVo);
        log.info(String.valueOf(logSeq));
        claimValidator.isValidStatus(requestClaimVo);
        ClaimDataCreator claimDataCreator = claimDataCreatorFactory.getClaimDataCreator(requestClaimVo.getCreatorType());
        ClaimDataVo claimDataVo = new ClaimDataVo();
        monitoringLogHelper.updateMonitoringLog(logSeq, claimDataVo);
    }
}
