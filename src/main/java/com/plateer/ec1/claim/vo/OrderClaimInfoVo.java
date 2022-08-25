package com.plateer.ec1.claim.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OrderClaimInfoVo {
    private String claimId;
    private String goodsName;
    private String cmnCd;
    private Long originalPrice;
    private Long SalePrice;
    private Long count;

    @NotBlank(message = "goodsNo 은 Null, \"\", \" \" 입력이 불가능합니다.")
    private String goodsNo;

    @NotBlank(message = "itemNo 은 Null, \"\", \" \" 입력이 불가능합니다.")
    private String itemNo;
}
