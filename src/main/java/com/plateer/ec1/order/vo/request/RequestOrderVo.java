package com.plateer.ec1.order.vo.request;

import com.plateer.ec1.order.enums.AfterStrategyType;
import com.plateer.ec1.order.enums.DataStrategyType;
import com.plateer.ec1.order.vo.DeliveryAddressVo;
import com.plateer.ec1.order.vo.OrderBenefitVo;
import com.plateer.ec1.order.vo.OrderGoodsVo;
import com.plateer.ec1.order.vo.OrderVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestOrderVo {

    private Long logSeq;

    @NotBlank(message = "orderNo 는 Null, \"\", \" \" 입력이 불가능합니다.")
    private String orderNo;

    @NotNull(message = "orderVo 는 Null 입력이 불가능합니다.")
    private OrderVo orderVo;

    @NotNull(message = "orderGoodsVoList 는 Null 입력이 불가능합니다.")
    private List<OrderGoodsVo> orderGoodsVoList;

    @NotNull(message = "orderBenefitVoList 는 Null 입력이 불가능합니다.")
    private List<OrderBenefitVo> orderBenefitVoList;

    @NotNull(message = "deliveryAddressVoList 는 Null 입력이 불가능합니다.")
    private List<DeliveryAddressVo> deliveryAddressVoList;

    private String json;

    @NotNull(message = "payInfoVo 는 Null 입력이 불가능합니다.")
    private PayInfoVo payInfoVo;

    @NotNull(message = "orderType 는 Null 입력이 불가능합니다.")
    private DataStrategyType orderType;

    @NotNull(message = "systemType 는 Null 입력이 불가능합니다.")
    private AfterStrategyType systemType;

}
