package com.plateer.ec1.common.model.order;

import com.plateer.ec1.order.vo.DeliveryAddressVo;
import lombok.*;

import java.sql.Timestamp;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OpDvpAreaInfoModel {

    private String ordNo;
    private Integer dvpSeq;
    private String rmtiNm;
    private String rmtiHpNo;
    private String rmtiAddr;
    private String rmtiAddrDtl;
    private Timestamp sysRegDtime;
    private String sysRegrId;
    private Timestamp sysModDtime;
    private String sysModrId;

    public OpDvpAreaInfoModel generalOrder(DeliveryAddressVo deliveryAddressVo) {
        return OpDvpAreaInfoModel
                .builder()
                .dvpSeq(deliveryAddressVo.getDvpSeq())
                .rmtiNm(deliveryAddressVo.getRmtiNm())
                .rmtiHpNo(deliveryAddressVo.getRmtiHpNo())
                .rmtiAddr(deliveryAddressVo.getRmtiAddr())
                .rmtiAddrDtl(deliveryAddressVo.getRmtiAddrDtl())
                .build();
    }

    public OpDvpAreaInfoModel mobileCouponOrder(DeliveryAddressVo deliveryAddressVo) {
        return OpDvpAreaInfoModel
                .builder()
                .dvpSeq(deliveryAddressVo.getDvpSeq())
                .rmtiNm(deliveryAddressVo.getRmtiNm())
                .rmtiHpNo(deliveryAddressVo.getRmtiHpNo())
                .build();
    }
}
