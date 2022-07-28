package com.plateer.ec1.order.strategy.impl.data;

import com.plateer.ec1.order.creator.OrderModelCreators;
import com.plateer.ec1.order.enums.DataStrategyType;
import com.plateer.ec1.order.strategy.DataStrategy;
import com.plateer.ec1.order.vo.OrderDataVo;
import com.plateer.ec1.order.vo.OrderProductView;
import com.plateer.ec1.order.vo.request.RequestOrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class EcouponDataStrategy implements DataStrategy {

    @Override
    public DataStrategyType getType() {
        return DataStrategyType.ECOUPON;
    }

    @Override
    @Transactional
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
