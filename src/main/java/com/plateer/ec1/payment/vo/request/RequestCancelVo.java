package com.plateer.ec1.payment.vo.request;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCancelVo {

    @NotBlank(message = "paymentType 은 Null, \"\", \" \" 입력이 불가능합니다.")
    private String paymentType;

    @NotBlank(message = "ordNo 은 Null, \"\", \" \" 입력이 불가능합니다.")
    private String ordNo;

    @NotNull
    private Long clmNo;

    @NotNull
    private Long cnclAmt;

}
