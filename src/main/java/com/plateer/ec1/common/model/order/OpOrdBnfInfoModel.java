package com.plateer.ec1.common.model.order;

import lombok.*;

import java.sql.Timestamp;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OpOrdBnfInfoModel {

    private String ordBnfNo;
    private Integer ordBnfAmt;
    private Long prmNo;
    private Long cpnIssNo;
    private Integer ordCnclBnfAmt;
    private Integer degrCcd;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;
    private String cpnKndCd;

    public OpOrdBnfInfoModel generalOrder() {
        return OpOrdBnfInfoModel
                .builder()
                .ordBnfNo()
                .prmNo()
                .cpnKndCd()
                .degrCcd()
                .ordBnfAmt()
                .ordCnclBnfAmt()
                .build();
    }

    public OpOrdBnfInfoModel mobileCouponOrder() {
        return OpOrdBnfInfoModel
                .builder()
                .ordBnfNo()
                .prmNo()
                .cpnKndCd()
                .degrCcd()
                .ordBnfAmt()
                .ordCnclBnfAmt()
                .build();
    }
}
