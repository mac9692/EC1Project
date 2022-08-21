package com.plateer.ec1.common.model.order;

import com.plateer.ec1.claim.vo.request.RequestClaimVo;
import com.plateer.ec1.utils.Utils;
import lombok.*;

import java.sql.Timestamp;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpOrdClmMntLogModel {
    private Long logSeq;
    private String ordNo;
    private String clmNo;
    private String reqPram;
    private String insData;
    private String uptData;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;
    private String procCcd;

    public OpOrdClmMntLogModel insertClaimMonitoringLog(RequestClaimVo requestClaimVo) {
        return OpOrdClmMntLogModel
                .builder()
                .ordNo(requestClaimVo.getOrderNo())
                .reqPram(Utils.convertObjectToJson(requestClaimVo))
                .build();
    }
}
