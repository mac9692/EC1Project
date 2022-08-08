package com.plateer.ec1.common.model.order;

import lombok.*;

import java.sql.Timestamp;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OpOrdCostInfoModel {

    private String ordCstNo;
    private Integer dvGrpNo;
    private String aplyCcd;
    private String orgOrdCstNo;
    private String clmNo;
    private String ordNo;
    private String dvAmtTpCd;
    private Long orgDvAmt;
    private Long dvBnfAmt;
    private Long aplyDvAmt;
    private String imtnRsnCcd;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;
    private String dvPlcTpCd;
    private Long cnclDvAmt;

    public OpOrdCostInfoModel generalOrder() {
        return OpOrdCostInfoModel
                .builder()
                .ordCstNo()
                .dvGrpNo()
                .aplyCcd()
                .dvAmtTpCd()
                .orgDvAmt()
                .aplyDvAmt()
                .dvBnfAmt()
                .dvPlcTpCd()
                .build();
    }

    public OpOrdCostInfoModel mobileCouponOrder() {
        return OpOrdCostInfoModel
                .builder()
                .ordCstNo()
                .dvGrpNo()
                .aplyCcd()
                .dvAmtTpCd()
                .orgDvAmt()
                .aplyDvAmt()
                .dvBnfAmt()
                .dvPlcTpCd()
                .build();
    }
}
