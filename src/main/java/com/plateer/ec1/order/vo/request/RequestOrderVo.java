package com.plateer.ec1.order.vo.request;

import com.plateer.ec1.order.enums.AfterStrategyType;
import com.plateer.ec1.order.enums.DataStrategyType;
import com.plateer.ec1.order.vo.DeliveryAddressVo;
import com.plateer.ec1.order.vo.OrderBenefitVo;
import com.plateer.ec1.order.vo.OrderGoodsVo;
import com.plateer.ec1.order.vo.OrderVo;
import com.plateer.ec1.payment.vo.OrderInfoVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import com.plateer.ec1.payment.vo.request.RequestPaymentVo;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestOrderVo {

    private Long logSeq;

    @NotBlank(message = "orderNo 는 Null, \"\", \" \" 입력이 불가능합니다.")
    private String orderNo;

    @Valid
    @NotNull(message = "orderVo 는 Null 입력이 불가능합니다.")
    private OrderVo orderVo;

    @Valid
    @NotNull(message = "orderGoodsVoList 는 Null 입력이 불가능합니다.")
    private List<OrderGoodsVo> orderGoodsVoList;

    @Valid
    @NotNull(message = "orderBenefitVoList 는 Null 입력이 불가능합니다.")
    private List<OrderBenefitVo> orderBenefitVoList;

    @Valid
    @NotNull(message = "deliveryAddressVoList 는 Null 입력이 불가능합니다.")
    private List<DeliveryAddressVo> deliveryAddressVoList;

    @Valid
    @NotNull(message = "payInfoVo 는 Null 입력이 불가능합니다.")
    private List<PayInfoVo> payInfoVoList;

    @NotNull(message = "orderType 는 Null 입력이 불가능합니다.")
    private String orderType;

    @NotNull(message = "systemType 는 Null 입력이 불가능합니다.")
    private String systemType;

    private String json;

    public RequestPaymentVo convertToRequestPaymentVo() {
        OrderInfoVo orderInfoVo = OrderInfoVo
                .builder()
                .ordNo(this.orderNo)
                .goodName(getOrderGoodsVoList().get(0).getOrdGoodsNo())
                .buyerName(getOrderVo().getOrdNm())
                .build();
        RequestPaymentVo requestPaymentVo = new RequestPaymentVo();
        requestPaymentVo.setOrderInfoVo(orderInfoVo);
        requestPaymentVo.setPayInfoVoList(payInfoVoList);
        return requestPaymentVo;
    }
}
