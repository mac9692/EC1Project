package com.plateer.ec1.claim.vo.request;

import com.plateer.ec1.claim.vo.DeliveryInfoVo;
import com.plateer.ec1.claim.vo.OrderClaimInfoVo;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestClaimVo {

    @NotBlank(message = "orderNo 는 Null, \"\", \" \" 입력이 불가능합니다.")
    private String orderNo;
    private String claimNo;
    private String creatorType;
    private String processorType;

    @Valid
    @NotNull(message = "orderClaimInfoVoList 는 Null 입력이 불가능합니다.")
    private List<OrderClaimInfoVo> orderClaimInfoVoList;
    private List<DeliveryInfoVo> deliveryInfoVoList;
    private Long prodAmt;
    private Long rfndAmt;
    private Long dlvAmt;

    @NotNull(message = "isAllGrpChecked 는 Null 입력이 불가능합니다.")
    private boolean isAllGrpChecked;
}
