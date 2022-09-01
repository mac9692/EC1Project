package com.plateer.ec1.claim.factory;


import com.plateer.ec1.claim.processor.ClaimProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ClaimProcessorFactory {
    private Map<String, ClaimProcessor> claimProcessorTypeMap = new LinkedHashMap<>();
    private final List<ClaimProcessor> claimProcessorList;

    public ClaimProcessorFactory(List<ClaimProcessor> claimProcessorList) {
        this.claimProcessorList = claimProcessorList;
    }

    @PostConstruct
    public void init() {
        claimProcessorList.forEach(c -> claimProcessorTypeMap.put(c.getType(), c));
    }

    public ClaimProcessor getClaimProcessor(String processorType) {
        return claimProcessorTypeMap.get(processorType);
    }
}
