package com.plateer.ec1.common.model.order;

import com.plateer.ec1.common.code.product.DVP0001;
import com.plateer.ec1.common.code.product.DVP0002;
import com.plateer.ec1.common.code.product.PRD0002;
import com.plateer.ec1.order.vo.CombinedDeliveryVo;
import com.plateer.ec1.order.vo.DeliveryAddressVo;
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

    public OpDvpInfoModel generalOrder(DeliveryAddressVo deliveryAddressVo, CombinedDeliveryVo combinedDeliveryVo) {
        setDvGrpNo(combinedDeliveryVo.getCombinedDeliveryNo());
        setDvpSeq(deliveryAddressVo.getDvpSeq());
        setDvMthdCd(DVP0001.DELIVERY.getType());
        return this;
    }

    public OpDvpInfoModel mobileCouponOrder(DeliveryAddressVo deliveryAddressVo, CombinedDeliveryVo combinedDeliveryVo) {
        setDvGrpNo(combinedDeliveryVo.getCombinedDeliveryNo());
        setDvpSeq(deliveryAddressVo.getDvpSeq());
        setDvMthdCd(PRD0002.NON_DELIVERY.getType());
        return this;
    }
}
