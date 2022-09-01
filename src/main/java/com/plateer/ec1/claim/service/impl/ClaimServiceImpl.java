package com.plateer.ec1.claim.service.impl;

import com.plateer.ec1.claim.factory.ClaimProcessorFactory;
import com.plateer.ec1.claim.processor.ClaimProcessor;
import com.plateer.ec1.claim.service.ClaimService;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClaimServiceImpl implements ClaimService {
    private final ClaimProcessorFactory claimProcessorFactory;

    @Override
    public void claim(RequestClaimVo requestClaimVo) {
        ClaimProcessor claimProcessor = claimProcessorFactory.getClaimProcessor(requestClaimVo.getCreatorType());
        claimProcessor.doProcess(requestClaimVo);
    }
}
