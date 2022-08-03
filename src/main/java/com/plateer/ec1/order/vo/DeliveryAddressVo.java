package com.plateer.ec1.order.vo;

import lombok.*;

import java.util.List;

@Builder
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAddressVo {
    private Integer dvpSeq;
    private String rmtiNm;
    private String rmtiHpNo;
    private String rmtiAddr;
    private String rmtiAddrDtl;
    private List<CombinedDeliveryVo> combinedDeliveryVoList;
}
