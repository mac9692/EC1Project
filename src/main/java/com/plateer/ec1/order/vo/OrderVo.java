package com.plateer.ec1.order.vo;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderVo {
    private String ordNo;
    @NotBlank(message = "mbrNo 는 Null, \"\", \" \" 입력이 불가능합니다.")
    private String mbrNo;
    private String ordTpCd;
    private String ordSysCcd;
    private String ordNm;
    @NotBlank(message = "ordSellNo 는 Null, \"\", \" \" 입력이 불가능합니다.")
    private String ordSellNo;
    @NotBlank(message = "ordAddr 는 Null, \"\", \" \" 입력이 불가능합니다.")
    private String ordAddr;
    @NotBlank(message = "ordAddrDtl 는 Null, \"\", \" \" 입력이 불가능합니다.")
    private String ordAddrDtl;
}
