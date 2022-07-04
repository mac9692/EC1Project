package com.plateer.ec1.promotion.vo.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class RequestPromotionVo {

    @NotNull(message = "프로모션 번호는 필수값입니다.")
    private Long prmNo;

    @NotNull(message = "회원번호는 필수값입니다.")
    private String mbrNo;
    private String ordNo;
    private Long cpnIssNo;

    @NotNull(message = "상품번호는 필수값입니다.")
    private String goodsNo;

    @NotNull(message = "단품번호는 필수값입니다.")
    private String itemNo;
}
