package com.plateer.ec1.claim.factory;

import com.plateer.ec1.claim.enums.ProcessorType;
import com.plateer.ec1.claim.processor.ClaimProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class ClaimProcessorFactory {

    private Map<String, ClaimProcessor> claimTypeMap = new LinkedHashMap<>();
    private final List<ClaimProcessor> claimProcessorList;

    public ClaimProcessorFactory(List<ClaimProcessor> claimProcessorList) {
        this.claimProcessorList = claimProcessorList;
    }

    @PostConstruct
    public void init() {
        claimProcessorList.forEach(c -> claimTypeMap.put(c.getType(), c));
    }

    public ClaimProcessor getClaimProcessor(String processorType) {
        log.info("클레임 종류에 맞는 프로세서 호출");
        return claimTypeMap.get(processorType);
    }
}
