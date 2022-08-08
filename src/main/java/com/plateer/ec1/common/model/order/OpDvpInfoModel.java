package com.plateer.ec1.common.model.order;

import com.plateer.ec1.common.code.product.DVP0001;
import lombok.*;

import java.sql.Timestamp;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OpDvpInfoModel {

    private int dvGrpNo;
    private String ordNo;
    private int dvpSeq;
    private String dvMthdCd;

    public OpDvpInfoModel generalOrder() {
        setDvGrpNo();
        setDvpSeq();
        setDvMthdCd(DVP0001.DELIVERY.getType());
        return this;
    }

    public OpDvpInfoModel mobileCouponOrder() {
        setDvGrpNo();
        setDvpSeq();
        setDvMthdCd(DVP0001.NON_DELIVERY.getType());
        return this;
    }
}
