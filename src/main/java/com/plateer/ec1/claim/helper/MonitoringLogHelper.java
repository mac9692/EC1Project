package com.plateer.ec1.claim.helper;

import com.plateer.ec1.claim.mapper.ClaimTrxMapper;
import com.plateer.ec1.claim.vo.ClaimDataVo;
import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import com.plateer.ec1.common.model.order.OpOrdClmMntLogModel;
import com.plateer.ec1.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MonitoringLogHelper {

    private final ClaimTrxMapper claimTrxMapper;

    public Long insertMonitoringLog(RequestClaimVo requestClaimVo) {
        OpOrdClmMntLogModel opOrdClmMntLogModel = new OpOrdClmMntLogModel().insertClaimMonitoringLog(requestClaimVo);
        claimTrxMapper.insertMonitoringLog(opOrdClmMntLogModel);
        return opOrdClmMntLogModel.getLogSeq();
    }

    public void updateMonitoringLog(Long logSeq, String updateMonitoringData) {
        log.info("모니터링 로그 UPDATE");
    }
}
