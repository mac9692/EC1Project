package com.plateer.ec1.order.strategy.impl.data;

import com.plateer.ec1.order.creator.OrderModelCreators;
import com.plateer.ec1.order.enums.DataStrategyType;
import com.plateer.ec1.order.strategy.DataStrategy;
import com.plateer.ec1.order.vo.OrderDataVo;
import com.plateer.ec1.order.vo.OrderProductView;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GeneralDataStrategy implements DataStrategy {
    @Override
    public DataStrategyType getType() {
        return DataStrategyType.GENERAL;
    }

    @Override
    public OrderDataVo create(RequestOrderVo requestOrderVo, OrderProductView orderProductView) {
        OrderDataVo orderDataVo = OrderDataVo
                .builder()
                .opOrdBaseModel(OrderModelCreators.commonOrderBase(requestOrderVo, orderProductView))
                .opGoodsInfoModel(OrderModelCreators.commonOrderProduct(requestOrderVo, orderProductView))
                .clmInfoModel(OrderModelCreators.commonOrderClaim(requestOrderVo, orderProductView))
                .opDvpAreaInfoModel(OrderModelCreators.commonOrderDelivery(requestOrderVo))
                .opOrdCostInfoModel(OrderModelCreators.commonOrderCost(requestOrderVo))
                .opOrdBnfInfoModel(OrderModelCreators.commonOrderBenefit(requestOrderVo))
                .opOrdBnfRelInfoModel(OrderModelCreators.commonOrderBenefitRelation(requestOrderVo))
                .build();
        return orderDataVo;
    }
}
