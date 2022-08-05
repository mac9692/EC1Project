package com.plateer.ec1.order.vo;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAddressVo {
    private Integer dvpSeq;

    @NotBlank(message = "rmtiNm 는 Null, \"\", \" \" 입력이 불가능합니다.")
    private String rmtiNm;

    @NotBlank(message = "rmtiHpNo 는 Null, \"\", \" \" 입력이 불가능합니다.")
    private String rmtiHpNo;

    @NotBlank(message = "rmtiAddr 는 Null, \"\", \" \" 입력이 불가능합니다.")
    private String rmtiAddr;

    @NotBlank(message = "rmtiAddrDtl 는 Null, \"\", \" \" 입력이 불가능합니다.")
    private String rmtiAddrDtl;

    @Valid
    private List<CombinedDeliveryVo> combinedDeliveryVoList;
}
