package com.plateer.ec1.order.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@ToString
@Getter
public class DeliveryAddressVo {
    private Integer dvpSeq;
    private String rmtiNm;
    private String rmtiHpNo;
    private String rmtiAddr;
    private String rmtiAddrDtl;
    private List<CombinedDeliveryVo> combinedDeliveryVoList;
}
