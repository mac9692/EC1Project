package com.plateer.ec1.common.code.order;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StCmnCd {

    private String cmnGrpCd;
    private String cmnCd;
    private String cmnGrpCdNm;
    private String cmnCdNm;
    private String ref1Val;
    private String ref2Val;
    private String useYn;
    private LocalDateTime sysRegDtime;
    private String sysRegrId;
    private LocalDateTime sysModDtime;
    private String sysModrId;
}
