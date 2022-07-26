package com.plateer.ec1.order.vo.request;

import com.plateer.ec1.order.enums.AfterStrategyType;
import com.plateer.ec1.order.enums.DataStrategyType;
import com.plateer.ec1.order.vo.DeliveryAddressVo;
import com.plateer.ec1.order.vo.OrderBenefitVo;
import com.plateer.ec1.order.vo.OrderGoodsVo;
import com.plateer.ec1.order.vo.OrderVo;
import com.plateer.ec1.payment.vo.PayInfoVo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@Setter
@Getter
@ToString
public class RequestOrderVo {
    private Long logSeq;
    private String orderNo;
    private OrderVo orderVo;
    private List<OrderGoodsVo> orderGoodsVoList;
    private List<OrderBenefitVo> orderBenefitVoList;
    private List<DeliveryAddressVo> deliveryAddressVoList;
    private String json;
    private PayInfoVo payInfoVo;
    private DataStrategyType orderType;
    private AfterStrategyType systemType;
}
