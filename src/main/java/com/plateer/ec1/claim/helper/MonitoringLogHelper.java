package com.plateer.ec1.claim.helper;

import com.plateer.ec1.claim.vo.Claim;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MonitoringLogHelper {

    public Long insertMonitoringLog(Claim claim) {
        log.info("모니터링 로그 INSERT");
        return null;
    }

    public void updateMonitoringLog(Long logKey, String logContents) {
        log.info("모니터링 로그 UPDATE");
    }
}
