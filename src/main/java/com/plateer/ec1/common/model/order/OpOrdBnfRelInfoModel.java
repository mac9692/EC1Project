package com.plateer.ec1.common.model.order;

import lombok.*;

import java.sql.Timestamp;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OpOrdBnfRelInfoModel {

    private String ordNo;
    private Integer ordSeq;
    private Integer procSeq;
    private String ordBnfNo;
    private String aplyCnclCcd;
    private Long aplyAmt;
    private String clmNo;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;

    public OpOrdBnfRelInfoModel generalOrder() {
        return OpOrdBnfRelInfoModel
                .builder()
                .ordBnfNo()
                .ordSeq()
                .procSeq()
                .aplyCnclCcd()
                .aplyAmt()
                .build();
    }

    public OpOrdBnfRelInfoModel mobileCouponOrder() {
        return OpOrdBnfRelInfoModel
                .builder()
                .ordBnfNo()
                .ordSeq()
                .procSeq()
                .aplyCnclCcd()
                .aplyAmt()
                .build();
    }
}
